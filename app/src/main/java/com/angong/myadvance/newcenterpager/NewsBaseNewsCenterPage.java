

package com.angong.myadvance.newcenterpager;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.angong.myadvance.utils.UIUtils;

/**
 * @author Administrator
 * @创建时间 2015-7-6 下午2:20:16
 * @描述 TODO
 * 
 *     @ svn提交者：$Author: gd $ @ 提交时间: $Date: 2015-07-06 14:57:36 +0800 (Mon, 06
 *     Jul 2015) $ @ 当前版本: $Rev: 33 $
 */
public class NewsBaseNewsCenterPage extends BaseNewsCenterPage
{

	@Override
	public View initView() {

		TextView tv = new TextView(UIUtils.getContext());
		tv.setText("新闻中心页面");
		tv.setGravity(Gravity.CENTER);
		return tv;

	}

	@Override
	public void initData() {
		// 设置数据

	}



}
