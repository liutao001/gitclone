//package com.casic;
//
//import java.util.Arrays;
//import java.util.Map;
//import java.util.Properties;
//import java.util.Set;
//
//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.clients.consumer.MockConsumer;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.Producer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//
//
//public class App {
//	private static Producer<String, String> producer;
//	private static Consumer<String, String> consumer;
//
//	/**
//	 * 构造
//	 */
//	public App() {
//	}
//
//	/**
//	 * 生产者,kafka生产者不能够从代码上生成topic,只能在服务器命令生成
//	 */
//
//	static {
//		Properties props = new Properties();
//		// 服务器地址
//		props.put("bootstrap.servers", "192.168.28.134:9092");
//		// 是否确认机制,保存完整性
//		props.put("acks", "all");
//		// 重试 0表示否, 发送消息失败是否重试
//		props.put("retries", "0");
//		// producer 批量发送的基本单位 默认是16kb
//		props.put("batch.size", "16384");
//		// batch批量
//		// 是sender线程在检查batch是否ready时,判断有没有过期的参数,默认是0ms
//		props.put("linger.ms", "1");
//		// 缓存存储器 默认为32m
//		props.put("buffer.memory", 33554432);
//		//键值的序列化 
//		
//		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//		producer = new KafkaProducer<>(props);
//
//	}
//	static {
//		Properties props = new Properties();
//		// kafka的交互地址
//		props.put("bootstrap.servers", "192.168.28.134:9092");
//		// 设置这个不是topic
//		// TODO 需要研究
//		props.put("group.id", "liutao");
//		// 是否设置自动提交
//		props.put("enable.auto.commit", "true");
//		// 自动提交的间隔时间
//		props.put("auto.commit.interval.ms", "1000");
//		// 设置session超时时间
//		props.put("session.timeout.ms", "30000");
//		//键值的反序列化
//		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//		consumer = new KafkaConsumer<>(props);
//		consumer.subscribe(Arrays.asList("liutao"));
//	}
//	/**
//	 * 发送消息
//	 */
//	public static void sendMsgToKafka(String msg){
//		producer.send(new ProducerRecord<String, String>("liutao", String.valueOf(System.currentTimeMillis()),JSON.toJSONString(msg)));
//		System.out.println("发送的消息是:"+msg);
//	}
//	
//	public static void getMsgToKafka(){
////		while(true){
//			ConsumerRecords<String, String> map = App.getKafkaConsumer().poll(100000);
//			
//			if(map.count()>0){
//				for (ConsumerRecord<String, String> consumerRecord : map) {
//					System.out.println("接收的消息是:"+consumerRecord);
//				}
//			}
//		
////		}
//		
//	}
//	public static Consumer<String, String> getKafkaConsumer(){
//		return consumer;
//	}
//	
//	
//	
//	public static void closeKafkaConsumer(){
//		consumer.close();
//	}
//	public static void main(String[] args) {
//		App.sendMsgToKafka("111");
//		App.getMsgToKafka();
//	}
//}
