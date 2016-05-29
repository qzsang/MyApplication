package com.qzsang.mapsearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchFunctionType;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;

public class MainActivity extends Activity implements NearbySearch.NearbyListener {

    Button btn_seach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_seach = (Button) findViewById(R.id.btn_seach);
        NearbySearch.getInstance(getApplicationContext()).addNearbyListener( this);
    }


    public void click(View v) {

        switch (v.getId()) {
            case R.id.btn_upload_for_one:

                //构造上传位置信息
                UploadInfo loadInfo = new UploadInfo();
//设置上传位置的坐标系支持AMap坐标数据与GPS数据
                loadInfo.setCoordType(NearbySearch.AMAP);
//设置上传数据位置,位置的获取推荐使用高德定位sdk进行获取
                loadInfo.setPoint(new LatLonPoint(39, 114.0002));
//设置上传用户id
                loadInfo.setUserID("test5");
//调用异步上传接口
                NearbySearch.getInstance(getApplicationContext())
                        .uploadNearbyInfoAsyn(loadInfo);

                break;
            case R.id.btn_seach:

//设置搜索条件
                NearbySearch.NearbyQuery query = new NearbySearch.NearbyQuery();
//设置搜索的中心点
                query.setCenterPoint(new LatLonPoint(39, 114));
//设置搜索的坐标体系
                query.setCoordType(NearbySearch.AMAP);
//设置搜索半径
                query.setRadius(10000);
//设置查询的时间
                query.setTimeRange(10000);
//设置查询的方式驾车还是距离
                query.setType(NearbySearchFunctionType.DISTANCE_SEARCH);

//调用异步查询接口
                NearbySearch.getInstance(getApplicationContext())
                        .searchNearbyInfoAsyn(query);

                break;
            case R.id.btn_user_clear:
//获取附近实例，并设置要清楚用户的id
                NearbySearch.getInstance(getApplicationContext()).setUserID("test4");
//调用异步清除用户接口
                NearbySearch.getInstance(getApplicationContext())
                        .clearUserInfoAsyn();
                btn_seach.setText("");
                break;
            case R.id.btn_exit:

//调用销毁功能，在应用的合适生命周期需要销毁附近功能
                NearbySearch.destroy();
                btn_seach.setText("");
                break;


        }

    }


    @Override
    public void onUserInfoCleared(int i) {
        Toast.makeText(getApplicationContext(),"onUserInfoCleared"+i,Toast.LENGTH_SHORT).show();
    }

    //周边检索的回调函数
    public void onNearbyInfoSearched(NearbySearchResult nearbySearchResult,
                                     int resultCode) {
        //搜索周边附近用户回调处理
        if (resultCode == 1000) {
            if (nearbySearchResult != null
                    && nearbySearchResult.getNearbyInfoList() != null
                    && nearbySearchResult.getNearbyInfoList().size() > 0) {
                NearbyInfo nearbyInfo = nearbySearchResult.getNearbyInfoList().get(0);
                btn_seach.setText("周边搜索结果为size " + nearbySearchResult.getNearbyInfoList().size() +
                        " first：" + nearbyInfo.getUserID() + "  " + nearbyInfo.getDistance() + "  "
                        + nearbyInfo.getDrivingDistance() + "  " + nearbyInfo.getTimeStamp() + "  " +
                        nearbyInfo.getPoint().toString());
            } else {
                btn_seach.setText("周边搜索结果为空");
            }
        } else {
            btn_seach.setText("周边搜索出现异常，异常码为：" + resultCode);
        }
    }

    @Override
    public void onNearbyInfoUploaded(int i) {
        Toast.makeText(getApplicationContext(),"onNearbyInfoUploaded"+i,Toast.LENGTH_SHORT).show();
    }
}
