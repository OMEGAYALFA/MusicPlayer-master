package cn.tedu.music_player_v1;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MusicAdapter extends BaseAdapter{
	private List<Music> data;
	private Context context;
	
	public MusicAdapter(Context context,List<Music> data)
	{
		setContext(context);
		setData(data);
	}
	
	public void setData(List<Music> data)
	{
		if(data == null)
			data = new ArrayList<Music>();
		this.data = data; 
	}
	
	public void setContext(Context context)
	{
		if(context == null)
		{
			throw new IllegalArgumentException("����Context������Ϊnull!!!");
		}
		this.context = context;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		//��ȡ����
		Music music = data.get(position);
		if(convertView == null)
		{
			//��ȡģ������
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(R.layout.music_item, null);
			holder = new ViewHolder();
			holder.title = (TextView)convertView.findViewById(R.id.tv_music_item_title);
			convertView.setTag(holder);	
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		//��ģ��������������
		holder.title.setText(music.getTitle());
		//����
		return convertView;
	}
	
	public class ViewHolder
	{
		TextView title;
	}
	
	@Override
	public Object getItem(int position) {
		return null;
	}
	
	@Override
	public long getItemId(int position) {
		return 0;
	}
}
