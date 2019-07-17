package com.jian.grpcImpl;

import com.ljzn.grpc.client.ClientAuthServiceGrpc;
import com.ljzn.grpc.client.ClientAuthServiceGrpc.ClientAuthServiceBlockingStub;
import com.ljzn.grpc.client.ClientAuthServiceGrpc.ClientAuthServiceStub;
import com.ljzn.grpc.client.HeartbeatRequest;
import com.ljzn.grpc.client.HeartbeatResponse;
import com.ljzn.grpc.personinfo.PersonInfoAuthServiceGrpc;
import com.ljzn.grpc.personinfo.PersoninfoRequest;
import com.ljzn.grpc.personinfo.PersoninfoResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 * 测试ＧＰＲＣ接口
 * @ClassName:  ClientTestGrpc   
 * @Description:TODO   
 * @author: JianLinWei
 * @email: jianlinwei_dream@163.com
 * @date:   2019年1月26日 下午4:25:58   
 *
 */
public class ClientTestGrpc {

	private static  ManagedChannel channel; 
    /**/    
    
    public static   void   test(){
    	channel  = ManagedChannelBuilder.forAddress("localhost", 50051)
 			   .usePlaintext()
 			                           .build();
    	PersonInfoAuthServiceGrpc.PersonInfoAuthServiceBlockingStub blockingstub = PersonInfoAuthServiceGrpc.newBlockingStub(channel);
 	   PersoninfoRequest request  = PersoninfoRequest.newBuilder().setDeviceSeril("1").build();
 	   PersoninfoResponse  response = blockingstub.getPersonInfo(request);
 	   System.out.println(response.getMessage());
    }
    
    
  /*  public static  void  testStream(){
    	channel  = ManagedChannelBuilder.forAddress("localhost", 50051)
  			   .usePlaintext().build();
    	ClientAuthServiceStub stub  = ClientAuthServiceGrpc.newStub(channel);
    	StreamObserver<HeartbeatRequest> observer  = stub.heartBeat(new StreamObserver<HeartbeatResponse>() {

			@Override
			public void onCompleted() {
			}

			@Override
			public void onError(Throwable arg0) {
			}

			@Override
			public void onNext(HeartbeatResponse arg0) {
				System.out.println("hh:"+arg0.getCode());
			}
		});
    	while(true){
    		try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		HeartbeatRequest request = HeartbeatRequest.newBuilder().setDeviceSeril("133330").build();
        	observer.onNext(request);
    	}
    	
    }
    */
    
  public static void main(String[] args) {
	
  } 
}
