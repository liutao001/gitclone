//package com.casic;
//
//import java.util.Properties;
//
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.Producer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//
//public class ProduceMSG {
//	public static void main(String[] args) {
//		//创建连接的配置文件属性
//		Properties prop=new Properties();
//		prop.put("bootstrap.servers", "192.168.28.134:9092");
//		prop.put("acks", "all");
//		prop.put("retries", "1");
//		prop.put("batch.size", "16384");
//		prop.put("linger.ms", "1");
//		prop.put("buffer.memory",33554432);
//		prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//		prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//		try {
//			Producer<String, String> producer=new KafkaProducer<>(prop);
//			producer.send(new ProducerRecord<String, String>("liutao", "this is a java  message"));
//			System.out.println("发送消息成功");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("发送消息失败");
//		}
//		
//	}
//}
