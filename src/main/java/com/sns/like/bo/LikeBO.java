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
		int like = likeMapper.selectLikeCountByPostIdAndUserId(postId, userId);
		if (like > 0) { // 존재 -> delete
			likeMapper.deleteLikeByPostIdUserId(postId, userId);
		} else { // 없음 -> insert
			likeMapper.insertLike(postId, userId);
		}
	}
}
