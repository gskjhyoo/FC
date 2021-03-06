package edu.skku.httphumanict.fcsnsprojectver001.app;

import android.content.Context;
import android.support.v4.media.MediaMetadataCompat;

import java.util.List;

import edu.skku.httphumanict.fcsnsprojectver001.app.activity.FCSNSLogoActivity;
import edu.skku.httphumanict.fcsnsprojectver001.app.activity.FCSNSRoomActivity;
import edu.skku.httphumanict.fcsnsprojectver001.app.activity.FCSNSable;
import edu.skku.httphumanict.fcsnsprojectver001.dto.Dialog;
import edu.skku.httphumanict.fcsnsprojectver001.dto.Room;
import edu.skku.httphumanict.fcsnsprojectver001.dto.User;
import edu.skku.httphumanict.fcsnsprojectver001.util.UtilGJSON;
import edu.skku.httphumanict.fcsnsprojectver001.util.UtilSPrefer;

/**
 *
 * Created by ProLab on 2016-07-26.
 */
public class FCSNSAppManager {

    int m_nPresRoomIdx = 0;

    private static FCSNSAppManager instance = new FCSNSAppManager();
    private FCSNSAppManager(){
        // null
    }
    public static FCSNSAppManager getInstance(){
        return  instance;
    }

    private FCSNSRoomActivity roomActivity;
    FCSNSLogoActivity logoActivity;

    /* App 에 필요한 DTO 클래스*/
    User user;
    List<Room> rooms;

    public void init(){
        //
    }

    public FCSNSRoomActivity getRoomActivity() {
        return roomActivity;
    }
    public void setRoomActivity(FCSNSRoomActivity roomActivity) {
        this.roomActivity = roomActivity;
    }
    public FCSNSLogoActivity getLogoActivity() {
        return logoActivity;
    }
    public void setLogoActivity(FCSNSLogoActivity logoActivity) {
        this.logoActivity = logoActivity;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<Room> getRooms() {
        return rooms;
    }
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void saveSharedPreference(Context _cContext) {
        // User 저장
        UtilSPrefer.saveStrData(_cContext, FCSNSable.SP_KEY, FCSNSable.SP_KEY_USER, getUser().toJson());
        // Room 배열 정보 저장
        UtilSPrefer.saveStrData(_cContext, FCSNSable.SP_KEY, FCSNSable.SP_KEY_ROOMS, UtilGJSON.getGson().toJson(getRooms()));
    }


    public List<Dialog> getPresDialogs() {
        return getRooms().get(getPresRoomIdx()).getDialogs();
    }

    public int getPresRoomIdx() {
        return m_nPresRoomIdx;
    }

    public void setPresRoomIdx(int _nPresRoomIdx) {
        m_nPresRoomIdx = _nPresRoomIdx;
    }

    public Room getPresentRoom() {
        return getRooms().get(getPresRoomIdx());
    }
}// end of class
