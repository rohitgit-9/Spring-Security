package com.test.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.entity.Voter;

@Repository
public interface VoteRepo extends JpaRepository<Voter, Integer> {

	@Query(value = "select candidate,count(*) as count from voter group by candidate", nativeQuery = true)
	public List<Object[]> getVoteCount();
}
