package com.example.demo.service;

import com.example.demo.bean.FunVersion;
import com.example.demo.bean.FunVersionExample;
import com.example.demo.mapper.third.FunVersionMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @ClassName: VersionService 
 * @Description: 版本升级控制类
 * @author zhengchubin
 * @date 2016年5月24日 上午9:25:47 
 *
 */
@Service
public class VersionService {
	
	@Resource
	private FunVersionMapper funVersionMapper;
	
	public boolean hasVersion(int versionCode,String channelId){
		FunVersionExample example = new FunVersionExample();
		example.createCriteria().andVersionCodeEqualTo(versionCode).andChannelIdEqualTo(channelId);
		List<FunVersion> list = funVersionMapper.selectByExample(example);
		return list.size() > 0 ? true : false;
	}
	
	
	
	public int addVersionBatch(List<FunVersion> list){
		return funVersionMapper.addFuncVersionBatch(list);
	}
	
	
	public List<FunVersion> findAll(int versionCode,String channelId){
		FunVersionExample example = new FunVersionExample();
		FunVersionExample.Criteria ca = example.createCriteria();
		ca.andVersionCodeEqualTo(versionCode);
		if(StringUtils.isNotBlank(channelId))
			ca.andChannelIdEqualTo(channelId);
		return funVersionMapper.selectByExample(example);
	}
	
	
	
	
	
	
	
}
