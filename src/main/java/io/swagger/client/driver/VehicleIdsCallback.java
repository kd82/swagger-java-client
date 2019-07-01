package io.swagger.client.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiException;
import io.swagger.client.model.VehicleIdsResponse;

public class VehicleIdsCallback implements ApiCallback<VehicleIdsResponse> {
    
	@Override
	public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) throws ApiException {
        throw new ApiException(statusCode, "Unable to get the Vehicle id details "+ e.getMessage());
	}

	@Override
	public void onSuccess(VehicleIdsResponse result, int statusCode, Map<String, List<String>> responseHeaders) throws ApiException{
		if(statusCode==Callback.SUCCESS_CODE) {
			Callback.setVehicleIDs(result.getVehicleIds());
			Callback.setMap(new ConcurrentHashMap<>());
			Callback.setDealers(new ArrayList<>());
			for(int vehicleId:Callback.getVehicleIDs()) {
			     Callback.getVehcilesApiInstance().vehiclesGetVehicleAsync(Callback.getDataSetID(), vehicleId,new VehicleCallback());
			}
		}
	}

	@Override
	public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {}

	@Override
	public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {}

}
