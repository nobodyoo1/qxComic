package com.comic.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.comic.bean.ComicInfo;
import com.comic.mapper.TbClassMapper;
import com.comic.mapper.TbComicMapper;
import com.comic.mapper.TbEpisodeMapper;
import com.comic.mapper.TbPictureMapper;
import com.comic.mapper.TbSiteMapper;
import com.comic.mapper.TbSourceMapper;
import com.comic.pojo.TbClass;
import com.comic.pojo.TbComic;
import com.comic.pojo.TbComicExample;
import com.comic.pojo.TbEpisode;
import com.comic.pojo.TbPicture;
import com.comic.pojo.TbSite;
import com.comic.pojo.TbSource;

@Service("tempService")
public class tempServiceImpl implements TempService {

	@Autowired
	private TbClassMapper classDao;
	@Autowired
	private TbSiteMapper siteDao;
	@Autowired
	private TbComicMapper comicDao;
	@Autowired
	private TbSourceMapper sourceDao;
	@Autowired
	private TbEpisodeMapper episodeDao;
	@Autowired
	private TbPictureMapper pictureDao;
	
	int classId = 0,comicId = 0,sourceId = 0,episodeId = 0,pictureId = 0;
	
	public int getNumFromStr(String str){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i)>=48 && str.charAt(i)<=57)
				sb.append(str.charAt(i));
		}
		return Integer.parseInt(sb.toString());
	}
	
	public void run() throws IOException {
		/*把网站信息加入*/
		TbSite site = new TbSite();
		site.setSitename("非常爱漫");
		siteDao.insertSelective(site);//insert
		System.out.println("插入站点...");
		
		/*读取分类列表，存储分类信息*/
		TbClass tbClass = new TbClass();
		TbComic tbComic = new TbComic();
		TbEpisode tbEpisode = new TbEpisode();
		TbPicture tbPicture = new TbPicture();
		TbSource tbSource = new TbSource();
		File dir = new File("D:\\pic\\非常爱漫\\");
		File[] classDirs = dir.listFiles();
		
		for(File classDir:classDirs ){
			if(classDir.isDirectory()){
				tbClass.setClassname(classDir.getName());
				classDao.insertSelective(tbClass);//insert
				classId++;
				System.out.println("插入类别"+tbClass.getClassname()+"...");
				/*读取1层子目录，存储漫画信息*/
				File[] comicDirs = classDir.listFiles();
				
				for(File comicDir:comicDirs){
					if(comicDir.isDirectory()){
						File jsonFile = new File(comicDir.getAbsolutePath() + "\\brief.json");
						FileInputStream fis = new FileInputStream(jsonFile);
						byte[] bytes = new byte[fis.available()];
						fis.read(bytes);
						fis.close();
						String jsonStr = new String(bytes, "utf-8");
						ComicInfo ci = JSON.parseObject(jsonStr, ComicInfo.class);
						tbComic.setComicname(ci.getComic_name());
						tbComic.setComicdptn(ci.getBrief_introduction());
						tbComic.setComicauth(ci.getComic_auth());
						tbComic.setClassid(classId);
						tbComic.setComiccover("非常爱漫/"+classDir.getName()+"/"+comicDir.getName()+"/cover.jpg");
						comicDao.insertSelective(tbComic);//insert
						comicId++;
						System.out.println("  插入漫画"+tbComic.getComicname()+"...");
						tbSource.setComicid(comicId);
						tbSource.setSiteid(1);
						sourceDao.insertSelective(tbSource);//insert
						sourceId++;
						File[] episodeDirs = comicDir.listFiles();
						
						for(File episodeDir:episodeDirs){
							if(episodeDir.isDirectory()){
								tbEpisode.setEpisodenum(getNumFromStr(episodeDir.getName()));
								tbEpisode.setSourceid(sourceId);
								episodeDao.insertSelective(tbEpisode);//insert
								episodeId++;
								System.out.println("    插入"+comicDir.getName()+"集"+tbEpisode.getEpisodenum()+"...");
								File[] pictureDirs = episodeDir.listFiles();
								
								for(File pictureDir:pictureDirs){
									if(pictureDir.isFile()){
										tbPicture.setEpisodeid(episodeId);
										tbPicture.setPicturenum(getNumFromStr(pictureDir.getName()));
										tbPicture.setPictureurl("非常爱漫/"+classDir.getName()+
												"/"+comicDir.getName()+"/"+episodeDir.getName()+"/"+pictureDir.getName());
										pictureDao.insertSelective(tbPicture);//insert
										pictureId++;
										System.out.println("      插入"+comicDir.getName()+"集"+tbEpisode.getEpisodenum()+"图片"+tbPicture.getPicturenum()+"...pictureId:"+pictureId);
									}
								}
							}
						}
					}
				}
			}
		}
		
		
	}

	@Override
	public void run2() throws Exception {
		String comicName = null;
		int comicId = -1;
		int sourceId = -1;
		int episodeId = -1;
		int picId = -1;
		int picNum = -1;
		final int siteId = 3;
		int episodeNum = -1;
		TbSource source = new TbSource();
		TbEpisode episode = new TbEpisode();
		TbPicture picture = new TbPicture();
		Path topDir = Paths.get("D:\\","pic","kuku");
		try(DirectoryStream<Path> entries = Files.newDirectoryStream(topDir,"*漫画")){
			for(Path entry : entries){
				comicName = entry.getFileName().toString().replace("漫画", "");
				/*在数据库中寻找漫画id，在source中添加*/
				TbComicExample comicExample = new TbComicExample();
				comicExample.createCriteria().andComicnameEqualTo(comicName);
				comicId = comicDao.selectByExample(comicExample).get(0).getComicid();
				source.setSourceid(null);
				source.setComicid(comicId);
				source.setSiteid(siteId);
				sourceDao.insertSelective(source);
				sourceId = source.getSourceid();
				try(DirectoryStream<Path> epiEntries = Files.newDirectoryStream(entry, "第*话")){
					for(Path epiEntry : epiEntries){
						episodeNum = getNumFromStr(epiEntry.getFileName().toString());
						episode.setEpisodeid(null);
						episode.setEpisodenum(episodeNum);
						episode.setSourceid(sourceId);
						episodeDao.insertSelective(episode); 
						episodeId = episode.getEpisodeid();
						try(DirectoryStream<Path> picEntries = Files.newDirectoryStream(epiEntry,"*.{jpg,png,gif,jpeg,bmp}")){
							for(Path picEntry : picEntries){
								picNum = getNumFromStr(picEntry.getFileName().toString());
								picture.setPictureid(null);
								picture.setEpisodeid(episodeId);
								picture.setPicturenum(picNum);
								picture.setPictureurl("kuku/" + entry.getFileName() + "/" + epiEntry.getFileName() + "/" + picEntry.getFileName());
								pictureDao.insertSelective(picture);
								System.out.println("      插入漫画"+entry.getFileName()+"集"+epiEntry.getFileName()+"图片"+picEntry.getFileName()+"...pictureId:"+picture.getPictureid());
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void run3() throws Exception {
		String comicName = null;
		int comicId = -1;
		int sourceId = -1;
		int episodeId = -1;
		int picId = -1;
		int picNum = -1;
		final int siteId = 3;
		int episodeNum = -1;
		TbSource source = new TbSource();
		TbEpisode episode = new TbEpisode();
		TbPicture picture = new TbPicture();
		Path topDir = Paths.get("D:\\","pic","4399");
		try(DirectoryStream<Path> entries = Files.newDirectoryStream(topDir)){
			for(Path entry : entries){
				if (Files.isDirectory(entry, LinkOption.values())) {
					comicName = entry.getFileName().toString().replace("漫画", "");
					/*在数据库中寻找漫画id，在source中添加*/
					TbComicExample comicExample = new TbComicExample();
					comicExample.createCriteria().andComicnameEqualTo(comicName);
					comicId = comicDao.selectByExample(comicExample).get(0).getComicid();
					source.setSourceid(null);
					source.setComicid(comicId);
					source.setSiteid(siteId);
					sourceDao.insertSelective(source);
					sourceId = source.getSourceid();
					try (DirectoryStream<Path> epiEntries = Files.newDirectoryStream(entry, "第*话")) {
						for (Path epiEntry : epiEntries) {
							episodeNum = getNumFromStr(epiEntry.getFileName().toString());
							episode.setEpisodeid(null);
							episode.setEpisodenum(episodeNum);
							episode.setSourceid(sourceId);
							episodeDao.insertSelective(episode);
							episodeId = episode.getEpisodeid();
							try (DirectoryStream<Path> picEntries = Files.newDirectoryStream(epiEntry,
									"*.{jpg,png,gif,jpeg,bmp}")) {
								for (Path picEntry : picEntries) {
									picNum = getNumFromStr(picEntry.getFileName().toString());
									picture.setPictureid(null);
									picture.setEpisodeid(episodeId);
									picture.setPicturenum(picNum);
									picture.setPictureurl("4399/" + entry.getFileName() + "/" + epiEntry.getFileName()
											+ "/" + picEntry.getFileName());
									pictureDao.insertSelective(picture);
									System.out.println("      插入漫画" + entry.getFileName() + "集" + epiEntry.getFileName()
											+ "图片" + picEntry.getFileName() + "...pictureId:" + picture.getPictureid());
								}
							}
						}
					} 
				}
			}
		}
	}
}
