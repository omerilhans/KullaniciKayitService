package com.android.service;

import com.android.entity.Device;
import com.android.entity.User;
import com.android.repository.DeviceRepository;
import com.android.repository.UserRepository;
import java.io.StringReader;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("kullanici")
public class UserResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("todb")
    public String toDatabase(String kullaniciString) {
        User kullanici = new User();
        JsonObject jsonKullanici = Json.createReader(new StringReader(kullaniciString)).readObject();

        kullanici.setUserName(jsonKullanici.getString("userName"));
        kullanici.setUserSurname(jsonKullanici.getString("userSurname"));
        kullanici.setUserNick(jsonKullanici.getString("userNick"));
        kullanici.setUserEmail(jsonKullanici.getString("userEmail"));
        kullanici.setUserBirthDate(jsonKullanici.getString("userBirthDate"));
        kullanici.setUserPassword(jsonKullanici.getString("userPassword"));
        kullanici.setCihazBilgisi(jsonKullanici.getString("cihazBilgisi"));

        UserRepository repo = new UserRepository();
        repo.persist(kullanici);
        repo.close();
        return "Done User";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("devicetodb")
    public String devRegistry(String detail) {
        Device device = new Device();
        JsonObject jsonDevice = Json.createReader(new StringReader(detail)).readObject();

        device.setRegistrationId(jsonDevice.getString("registrationId"));
        device.setCihazBilgisi(jsonDevice.getString("cihazBilgisi"));

        DeviceRepository repo = new DeviceRepository();
        repo.persist(device);
        repo.close();
        return "Done Device";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getregid")
    public String getDeviceInfo(String info) {
        Device device = new Device();
        JsonObject jsonDevice = Json.createReader(new StringReader(info)).readObject();
        DeviceRepository repo = new DeviceRepository();
        String deviceRegistrationId = repo.findRegByDeviceInfo(jsonDevice.getString("cihazBilgisi"));
        repo.close();
        return deviceRegistrationId;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("checkuser")
    public String checkUser(String userNick) {
        UserRepository repo = new UserRepository();
        JsonObject jsonUserNick = Json.createReader(new StringReader(userNick)).readObject();
        String userN = jsonUserNick.getString("userNick");

        User user = null;
        user = repo.findUserByNickname(userN);
        repo.close();
        if (user != null) {
            return "1";
        }
        return "0";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("checklogin")
    public String checkLogin(String login) {
        JsonObject jsonLogin = Json.createReader(new StringReader(login)).readObject();
        String userNick = jsonLogin.getString("userNick");
        String userPassword = jsonLogin.getString("userPassword");

        UserRepository repo = new UserRepository();
        List<User> userList = repo.list();

        for (User user : userList) {
            if (user.getUserNick().equals(userNick) && user.getUserPassword().equals(userPassword)) {
                return "Match";
            }
        }
        return "Dismatch";
    }

    //    @POST
//    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
//    @Path("addpoto")
//    public void addPoto(@QueryParam("resim") byte[] image) {
//        // buraya resim 
//        System.out.println("addPoto geldi");
//    }
}
