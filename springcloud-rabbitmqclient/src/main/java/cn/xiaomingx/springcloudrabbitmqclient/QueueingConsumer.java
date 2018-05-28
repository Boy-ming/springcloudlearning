package cn.xiaomingx.springcloudrabbitmqclient;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author: Ming
 * @PROJECT: springcloudlearning
 * @Package cn.xiaomingx.springcloudrabbitmqclient
 * @date 2018/5/25 16:24
 * @Description: ${todo}
 */
public class QueueingConsumer implements Consumer {
    public QueueingConsumer(Channel channel){

    }
    @Override
    public void handleConsumeOk(String s) {

    }

    @Override
    public void handleCancelOk(String s) {

    }

    @Override
    public void handleCancel(String s) throws IOException {

    }

    @Override
    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    @Override
    public void handleRecoverOk(String s) {

    }

    @Override
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {

    }
}
