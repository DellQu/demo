package com.qud.apitest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SourceTest {

    public static void main(String[] args) throws Exception {
//        readDataByCollection();
//        readDataByFile();
        readDataByKafka();
    }

    /**
     *  从自定义的集合中读取数据
     */
    private static void readDataByCollection() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        List<SensorReading> list = new ArrayList<SensorReading>();
        for (int i = 0; i < 5; i++) {
            SensorReading sensorReading = new SensorReading();
            sensorReading.setId("sensor_" + i);
            sensorReading.setTimestamp(System.currentTimeMillis());
            sensorReading.setTemperature(36.054);
            list.add(sensorReading);
        }
        DataStreamSource<SensorReading> sensorReadingDataStreamSource = env.fromCollection(list);
        sensorReadingDataStreamSource.print("sensorReadingDataStreamSource").setParallelism(1);
        env.execute("source test");
        
    }

    /**
     *  从文件中读取数据
     */
    private static void readDataByFile() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> stringDataStreamSource = env.readTextFile("D:\\qud\\demo\\flink\\flink-data-stream-api\\src\\main\\resources\\sensor.txt");
        stringDataStreamSource.print("sensorReadingDataStreamSource").setParallelism(1);
        env.execute("source test");
    }

    /**
     *  从Kafka中读取数据
     */
    private static void readDataByKafka() {
        Properties properties = new Properties();

    }
}

//温度传感器
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
class SensorReading {

    private String id;

    private Long timestamp;

    private Double temperature;
}


