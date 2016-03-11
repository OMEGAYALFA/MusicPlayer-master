package cn.tedu.music_player_v1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.os.Environment;
import android.util.Log;

public class MusicDao {
	
	public List<Music> getData()
	{
		List<Music> musics = new ArrayList<Music>();
		
		if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()))
		{
			//�ж�sdcard�Ƿ����
			File musicDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			
			//�ж��ļ����Ƿ����
			if(musicDir.exists())
			{
				//��ȡĿ¼�������ļ�
				File[] files = musicDir.listFiles();
				//����
				for(int i=0;i<files.length;i++)
				{
					//�ж��Ƿ��ļ�
					if(files[i].isFile())
					{
						//�ж���չ��
						if(files[i].getName().toLowerCase(Locale.CHINA).endsWith(".mp3"))
						{
							Log.d("tedu",""+files[i]);
							Music music = new Music();
							music.setPath(files[i].getAbsolutePath());
							music.setTitle(files[i].getName().substring(0, files[i].getName().length()-4));                                          
							musics.add(music);
						}
					}
				}
			}
		}
		return musics;
	}
}
