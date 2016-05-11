package com.balloon.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.balloon.entity.Account;
import com.balloon.entity.Member;
import com.balloon.mapper.AccountMapper;
import com.balloon.mapper.MemberMapper;
import com.balloon.service.LoginService;
import com.balloon.utils.encryption.MD5Tools;

/**
 * errorCode 1 成功 2 密码错误 3 账号不存在 4 账号已经存在 5注册失败
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Resource
	private AccountMapper accountMapper;
	@Resource
	private MemberMapper memberMapper;

	/**
	 * 登陆
	 */
	public Map<String, Object> login(String account, String password) {
		Map<String, Object> result = new HashMap<String, Object>();

		Account Login = new Account();
		Login.setAccount(account);
		Login.setPassword(password);
		Account userAccount = accountMapper.selectByAccountAndPsd(Login);
		System.err.println("userAccount:" + (userAccount == null));
		if (userAccount != null) {
			result.put("msg", "success");
			result.put("code", 1);
			Member member=memberMapper.selectByPrimaryAccount(account);
			result.put("member", member);
		} else {
			Account Login1 = new Account();
			Login1.setAccount(account);
			Account userAccount1 = accountMapper.selectByAccount(Login1);
			if (userAccount1 == null) {
				result.put("msg", "账号不存在");
				result.put("code", 3);
			} else {
				result.put("msg", "密码不正确");
				result.put("code", 2);
			}

		}
		return result;
	}

	/**
	 * 注册
	 */
	@Override
	public Map<String, Object> regitser(String account, String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		Account reg = new Account();
		reg.setAccount(account);
		Account regIsExist = accountMapper.selectByAccount(reg);
		if (regIsExist != null) {
			result.put("msg", "账号已经存在");
			result.put("code", 4);
			return result;
		} else {
			reg.setMemberId(MD5Tools.encode(account));
			reg.setPassword(password);

			int resultCode = accountMapper.insertSelective(reg);
			if (resultCode == 1) {
				Member member = new Member();
				member.setAccount(account);
				member.setPhone(account);
				member.setMemberId(MD5Tools.encode(account));
				member.setCreatedate(new Date());
				int code = memberMapper.insert(member);
				if (code == 1) {
					Member memberReturn = memberMapper.selectByPrimaryAccount(account);
					if (memberReturn != null) {
						result.put("msg", "注册成功");
						result.put("code", 1);
						result.put("member", memberReturn);
					} else {
						result.put("msg", "注册失败");
						result.put("code", 5);
					}
				} else {
					result.put("msg", "注册失败");
					result.put("code", 5);
				}
			} else {
				System.out.println("6");
				result.put("msg", "注册失败");
				result.put("code", 5);
			}
			return result;
		}

	}

	/**
	 * 获取用户信息
	 */
	@Override
	public Member getMemberInfo(String member_id) {
		return null;
	}


}
