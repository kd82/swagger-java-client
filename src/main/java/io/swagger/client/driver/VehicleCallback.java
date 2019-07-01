package io.swagger.client.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.model.VehicleAnswer;
import io.swagger.client.model.VehicleResponse;

public class VehicleCallback implements ApiCallback<VehicleResponse> {
		
	@Override
	public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) throws ApiException {
		throw new ApiException(statusCode, "Unable to get the Vehicle details "+ e.getMessage());
	}

	@Override
	public void onSuccess(VehicleResponse result, int statusCode, Map<String, List<String>> responseHeaders) throws ApiException {
		if(statusCode==Callback.SUCCESS_CODE) {
			List<VehicleAnswer> vehicles=new ArrayList<>();
            if(!Callback.map.containsKey(result.getDealerId())) {
            	vehicles.add(new VehicleAnswer(result.getVehicleId(), result.getYear(),result.getMake(), result.getModel()));
            	Callback.map.put(result.getDealerId(),vehicles);
                DealerCallback callback=new DealerCallback();
			    Callback.getDealertApiInstance().dealersGetDealerAsync(Callback.getDataSetID(), result.getDealerId(),callback);
            }
            else {
            	vehicles=Callback.map.get(result.getDealerId());
            	vehicles.add(new VehicleAnswer(result.getVehicleId(), result.getYear(),result.getMake(), result.getModel()));
            	Callback.map.put(result.getDealerId(),vehicles);
            }
		}
	}

	@Override
	public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {}

	@Override
	public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {}

}
