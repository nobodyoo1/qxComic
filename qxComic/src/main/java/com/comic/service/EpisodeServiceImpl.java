package com.comic.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.bean.MyConstants;
import com.comic.bean.MyUtils;
import com.comic.mapper.TbEpisodeMapper;
import com.comic.mapper.TbHistoryMapper;
import com.comic.mapper.TbPictureMapper;
import com.comic.mapper.TbSourceMapper;
import com.comic.mapper.TbUserMapper;
import com.comic.pojo.TbEpisode;
import com.comic.pojo.TbEpisodeExample;
import com.comic.pojo.TbHistory;
import com.comic.pojo.TbHistoryExample;
import com.comic.pojo.TbPicture;
import com.comic.pojo.TbPictureExample;
import com.comic.pojo.TbPictureExample.Criteria;
import com.comic.pojo.TbSource;

@Service("episodeService")
public class EpisodeServiceImpl implements EpisodeService {
	
	@Autowired
	private TbPictureMapper pictureDao;
	@Autowired
	private TbHistoryMapper historyDao;
	@Autowired
	private TbUserMapper userDao;
	@Autowired
	private TbEpisodeMapper episodeDao;
	@Autowired
	private TbSourceMapper sourceDao;

	@Override
	public List<TbPicture> getPics(Integer episodeId,Integer page,Integer userId) {
		if(userDao.selectByPrimaryKey(userId) == null){
			return new ArrayList<>();
		}
		
		TbPictureExample pictureExample = new TbPictureExample();
		Criteria pictureCriteria = pictureExample.createCriteria();
		pictureCriteria.andEpisodeidEqualTo(episodeId);
		List<TbPicture> allPics = pictureDao.selectByExample(pictureExample);
		
		Comparator<TbPicture> comparator = new Comparator<TbPicture>() {
			public int compare(TbPicture p1, TbPicture p2) {
				return p1.getPicturenum() - p2.getPicturenum();
			}
		};
		Collections.sort(allPics, comparator);
		
		List<TbPicture> pics = MyUtils.selectByPage(allPics, page, MyConstants.ConsType.PICS);
		MyUtils.addPrefixforPics(pics);
		
		if (pics.size() > 0) {
			TbEpisode episode = episodeDao.selectByPrimaryKey(episodeId);
			TbSource source = sourceDao.selectByPrimaryKey(episode.getSourceid());
			TbHistoryExample historyExample = new TbHistoryExample();
			com.comic.pojo.TbHistoryExample.Criteria historyCriteria = historyExample.createCriteria();
			historyCriteria.andComicidEqualTo(source.getComicid());
			historyCriteria.andUseridEqualTo(userId);
			List<TbHistory> histories = historyDao.selectByExample(historyExample);
			TbHistory history = new TbHistory();
			history.setComicid(source.getComicid());
			history.setUserid(userId);
			history.setViewtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			/*观看历史，格式{episodeId}#{episodeNum}#{page}#{pictureNum}，historyLocation格式：集id#第几集#page#第几张图*/
			history.setHistorylocation(
					episodeId + "#" + episode.getEpisodenum() + "#" + page + "#" + pics.get(0).getPicturenum());
			if (histories.size() == 1) {
				history.setHistoryid(histories.get(0).getHistoryid());
				historyDao.updateByExample(history, historyExample);
			} else {
				if (histories.size() > 1) {
					historyDao.deleteByExample(historyExample);
				}
				historyDao.insert(history);
			} 
		}
		return pics;
	}

	@Override
	public Integer getNext(Integer episodeId) {
		TbEpisode lastEpisode = episodeDao.selectByPrimaryKey(episodeId);
		TbEpisodeExample episodeExample = new TbEpisodeExample();
		episodeExample.createCriteria().andSourceidEqualTo(lastEpisode.getSourceid())
			.andEpisodenumEqualTo(lastEpisode.getEpisodenum() + 1);
		List<TbEpisode> episodes = episodeDao.selectByExample(episodeExample);
		return episodes.size() == 0 ? 0 : episodes.get(0).getEpisodeid();
	}

}
