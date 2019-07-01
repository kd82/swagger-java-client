package io.swagger.client.driver;

import java.util.List;
import java.util.Map;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.model.DealerAnswer;
import io.swagger.client.model.DealersResponse;

public class DealerCallback implements ApiCallback<DealersResponse> {

	@Override
	public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) throws ApiException {
		throw new ApiException(statusCode, "Unable to get the Dealer details "+ e.getMessage());
	}
	
	@Override
	public void onSuccess(DealersResponse result, int statusCode, Map<String, List<String>> responseHeaders) throws ApiException { 
		if(statusCode==Callback.SUCCESS_CODE) {
			DealerAnswer dealer=new DealerAnswer();
			dealer.setDealerId(result.getDealerId());
			dealer.setName(result.getName());
			Callback.dealers.add(dealer);
			if(Callback.dealers.size()==Callback.getMap().size()) {
				for(DealerAnswer dealerAnswers:Callback.dealers) {
					dealerAnswers.setVehicles(Callback.getMap().get(dealerAnswers.getDealerId()));
				}
				Callback.PostAnswer(Callback.dealers);
			}
		}
	}

	@Override
	public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {}

	@Override
	public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {}
   
}
