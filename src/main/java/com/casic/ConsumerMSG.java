//package com.casic;
//
//import java.util.Arrays;
//import java.util.Properties;
//
//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//
//public class ConsumerMSG {
//	public static void main(String[] args) {
//		Properties prop = new  Properties();
//		prop.put("bootstrap.servers", "192.168.28.134:9092");
//		// 设置这个不是topic
//		// TODO 需要研究
//		prop.put("group.id", "test");
//		// 是否设置自动提交
//		prop.put("enable.auto.commit", "true");
//		// 自动提交的间隔时间
//		prop.put("auto.commit.interval.ms", "1000");
//		// 设置session超时时间
//		prop.put("session.timeout.ms", "30000");
//		//键值的反序列化
//		prop.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//		prop.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//		Consumer<String,String> consumer=new  KafkaConsumer<>(prop);
//		consumer.subscribe(Arrays.asList("liutao"));
//		while(true){
//		ConsumerRecords<String, String> records = consumer.poll(100);
//		
//		if(records.count()>0){
//			System.out.println("接收消息成功");
//		}
//		}
//	}
//
//}
