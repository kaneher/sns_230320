package com.sns.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.like.dao.LikeMapper;

@Service
public class LikeBO {
	
	@Autowired
	private LikeMapper likeMapper;

	// input : postId, userId
	// output : void
	public void likeToggle(int postId, int userId) {
		// 셀렉트 => count(*)
		int like = likeMapper.selectLikeCountByPostIdOrUserId(postId, userId);
		if (like > 0) { // 존재 -> delete
			likeMapper.deleteLikeByPostIdUserId(postId, userId);
		} else { // 없음 -> insert
			likeMapper.insertLike(postId, userId);
		}
	}
	
	// input : postId
	// output : 좋아요 개수(int)
	public int getLikeCountByPostId(int postId) {
		return likeMapper.selectLikeCountByPostIdOrUserId(postId, null);
	}
	
	// input : postId, userId
	// output : 좋아요 여부 boolean
	public boolean filledLike(int postId, Integer userId) {
		// 비로그인
		if (userId == null) {
			return false;
		}
		
		// 로그인
		return likeMapper.selectLikeCountByPostIdOrUserId(postId, userId) > 0;
	}
}
