package com.kshrd.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kshrd.model.Message;
import com.kshrd.model.utility.Paging;

@Repository
public interface MessageRepository {
	
	@Select("select id, text, description from message order by id desc limit #{limit} offset #{offset}")
	public List<Message> findAll(Paging paging);
	
	@Select("select id, text, description from message where id = #{id}")
	public Message findById(Integer id);
	
	@Select("select count(*) from message")
	public Integer totalRecord();
	
}
