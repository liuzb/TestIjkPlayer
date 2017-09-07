package testijkplayer.bob.com.testijkplayersample.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import testijkplayer.bob.com.testijkplayersample.R;
import testijkplayer.bob.com.testijkplayersample.ijkplayer.media.IjkVideoView;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * create by bob.liu
 * 2017/09/07
 * qq:1774900724
 *
 */
public class MainActivity extends AppCompatActivity implements IMediaPlayer.OnPreparedListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener {

    private IjkVideoView videoView;
    private  String  videoUrl="http://gslb.miaopai.com/stream/3D~8BM-7CZqjZscVBEYr5g__.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initVideo();
    }

    public void initView(){
        videoView=(IjkVideoView)this.findViewById(R.id.videoView);
    }
    public  void initVideo(){
        IjkMediaPlayer.loadLibrariesOnce(null);//初始化ijkplayer
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        videoView.setVideoURI(Uri.parse(videoUrl));
        videoView.setOnPreparedListener(this);//设置缓冲准备监听
        videoView.setOnInfoListener(this);//设置信息监听
        videoView.setOnCompletionListener(this);//设置播放完成监听
        videoView.setOnErrorListener(this);//设置错误信息监听
    }

    @Override
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        videoView.start();
    }

    @Override
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onCompletion(IMediaPlayer iMediaPlayer) {

    }

    @Override
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
        return false;
    }
}
