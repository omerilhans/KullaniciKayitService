package com.android.repository;

import com.android.base.BaseRepository;
import com.android.entity.Device;
import java.util.List;

public class DeviceRepository extends BaseRepository<Device> {

    public DeviceRepository() {
        super(Device.class);
    }

    public String findRegByDeviceInfo(String info) {
        List<Device> devList = super.list();
        String reg = "";
        for (Device device : devList) {
            if (device.getCihazBilgisi().equals(info)) {
                reg = device.getRegistrationId();
                break;
            }
        }
        return reg;
    }

}
