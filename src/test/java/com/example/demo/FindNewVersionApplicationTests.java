package com.example.demo;

import com.example.demo.common.JsonUtil;
import com.example.demo.service.VersionService;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class FindNewVersionApplicationTests {

	@Resource
	private VersionService versionService;

	@Test
	public void newVersionForProduct(){


		String jsonStr = "{\"clientInfo\":{\"deviceId\":\"12790661-31F3-479D-8712-0BC82A38\",\"os\":\"ios\",\"appVersion\":\"2.7.2\",\"appName\":\"botao\",\"channelId\":\"309488\",\"hardwareModel\":\"iPhone 6S\",\"systemVersion\":\"11.3.1\",\"TDFingerprint\":\"eyJ0b2tlbklkIjoiT21uWFwvek5cL1lGcXBwUlBiVHEzNWYxbThyU0crWmVqMDlIZGpNUE5PbDl1VDQ1ZmdRZWdTZEplOVkxUVB4UXIxQzRYelVINzN2RW9NS0VoSW5nSHFqQT09Iiwib3MiOiJpT1MiLCJwcm9maWxlVGltZSI6NDM4LCJ2ZXJzaW9uIjoiMy4wLjUifQ==\",\"versionCode\":\"54\"}}";
		try
		{
			ObjectMapper jsonpObject = new ObjectMapper();
			JsonNode rootNote = jsonpObject.readTree(jsonStr);
			JsonNode node = rootNote.path("clientInfo");
			Integer versionCode = Integer.valueOf(node.path("versionCode").asInt());
			String current_device = node.path("os").asText();
			Integer channelId = Integer.valueOf(node.path("channelId").asInt());

			JsonNode versionConfig = getApolloConfigJson();

			JsonNode device = null;
			switch (current_device.hashCode())
			{
				case -861391249:
					if (current_device.equals("android")) {
						break;
					}
				case 104461:
					if (current_device.equals("ios"))
					{
						device = versionConfig.path("ios");
					}
			}

			String latest_version_name = device.path("latest_version_name").asText();
			String latest_app_version = device.path("latest_app_version").asText();
			Integer latest_version_code = Integer.valueOf(device.path("latest_version_code").asInt());
			Integer lowest_version_code = Integer.valueOf(device.path("lowest_version_code").asInt());
			String latest_version_download_url = device.path("latest_version_download_url").asText();
			if (("android".equals(current_device)) && (channelId != null)) {
				latest_version_download_url =

						latest_version_download_url.replaceAll("version", String.valueOf(latest_version_code)).replaceAll("appVersion", latest_app_version).replaceAll("channelId", String.valueOf(channelId));
			}
			ObjectNode result = JsonUtil.createObjectNode();
			result.put("latestVersionName", latest_version_name);
			System.out.println(result.asText());
			result.put("latestVersionDownloadUrl", latest_version_download_url);
			if (versionCode.intValue() < lowest_version_code.intValue())
			{
				result.put("needUpdate", true);
				result.put("hasNewVersion", true);
				result.put("latestVersionDescribe", device.path("latest_version_describe").asText());
				result.put("describeTitle", device.path("latest_version_describe_title").asText());
				result.put("describeContent", device.path("latest_version_describe_content").asText());
			}
			else if (versionCode.intValue() >= lowest_version_code.intValue() && versionCode.intValue() < latest_version_code.intValue() && this.versionService.hasVersion(latest_version_code.intValue(), channelId+""))
			{
				result.put("needUpdate", false);
				result.put("hasNewVersion", true);
				result.put("latestVersionDescribe", device.path("latest_version_describe").asText());
				result.put("describeTitle", device.path("latest_version_describe_title").asText());
				result.put("describeContent", device.path("latest_version_describe_content").asText());
			}
			else
			{
				result.put("needUpdate", false);
				result.put("hasNewVersion", false);
				result.put("latestVersionDescribe", "");
				result.put("describeTitle", "");
				result.put("describeContent", "");
			}
			System.out.println(result.asText());
		}
		catch (Exception e)
		{
			System.out.println("失败！！！！！！"+e);
		}
	}



	@Test
	public void newVersionForTest(){


	}




	static JsonNode getApolloConfigJson(){


		String configJson = "{\n" +
				"    \"ios\": {\n" +
				"        \"latest_version_name\": \"2.8版本\",\n" +
				"        \"latest_version_code\": \"55\",\n" +
				"        \"latest_app_version\": \"2.8\",\n" +
				"        \"lowest_version_name\": \"1.1\",\n" +
				"        \"lowest_version_code\": \"1\",\n" +
				"        \"latest_version_download_url\": \"https://itunes.apple.com/cn/app/7tian-lian-suo-jiu-dian/id416048526?mt=8\",\n" +
				"        \"latest_version_describe\": \"铂涛旅行2.8新特性\\n\\n1、发票、充值功能搬家啦~ 在“我的”页面可以找到；\\n2、钱包页样式优化，支持借款；\\n3、订单支付方式增加分期支付；\\n\",\n" +
				"        \"latest_version_describe_title\": \"铂旅行2.8新特性\",\n" +
				"        \"latest_version_describe_content\": \"1、发票、充值功能搬家啦~ 在“我的”页面可以找到；\\n2、钱包页样式优化，支持借款；\\n3、订单支付方式增加分期支付；\\n\"\n" +
				"    },\n" +
				"    \"android\": {\n" +
				"        \"latest_version_name\": \"2.8版本\",\n" +
				"        \"latest_version_code\": \"32\",\n" +
				"        \"latest_app_version\": \"2.8\",\n" +
				"        \"lowest_version_name\": \"1.2.1版本\",\n" +
				"        \"lowest_version_code\": \"1\",\n" +
				"        \"latest_version_download_url\": \"http://imgs.plateno.com:8080/app-trip/apk/version/botaoota_appVersion_channelId.apk\",\n" +
				"        \"latest_version_describe\": \"铂涛旅行2.8新特性\\n\\n1、发票、充值功能搬家啦~ 在“我的”页面可以找到；\\n2、钱包页样式优化，支持借款；\\n3、订单支付方式增加分期支付；\\n\",\n" +
				"        \"latest_version_describe_title\": \"铂涛旅行2.8新特性\",\n" +
				"        \"latest_version_describe_content\": \"1、发票、充值功能搬家啦~ 在“我的”页面可以找到；\\n2、钱包页样式优化，支持借款；\\n3、订单支付方式增加分期支付；\\n\"\n" +
				"    }\n" +
				"}";

		try {
			ObjectMapper jsonpObject = new ObjectMapper();
			return jsonpObject.readTree(configJson);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("获取线上阿波罗配置失败！！");
		}
		return null;
	}

}
