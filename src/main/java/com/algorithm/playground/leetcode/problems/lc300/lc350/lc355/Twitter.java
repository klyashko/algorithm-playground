package com.algorithm.playground.leetcode.problems.lc300.lc350.lc355;

import java.util.*;

/**
 * https://leetcode.com/problems/design-twitter/
 * <p>
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
public class Twitter {

	private Map<Integer, LinkedList<Tweet>> userToTweet = new HashMap<>();
	private Map<Integer, Set<Integer>> userToFollowee = new HashMap<>();
	private int time;

	/**
	 * Initialize your data structure here.
	 */
	public Twitter() { }

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		userToTweet.computeIfAbsent(userId, this::newLinkedList).addFirst(new Tweet(tweetId, time++));
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed.
	 * Each item in the news feed must be posted by users who the user followed or by the user herself.
	 * Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		Queue<Data> queue = new PriorityQueue<>();
		List<Integer> tweets = new ArrayList<>();

		Set<Integer> followees = userToFollowee.getOrDefault(userId, Collections.emptySet());

		for (Integer next : followees) {
			next(queue, userToTweet.computeIfAbsent(next, this::newLinkedList).iterator());
		}

		if (!followees.contains(userId)) {
			next(queue, userToTweet.computeIfAbsent(userId, this::newLinkedList).iterator());
		}

		while (!queue.isEmpty() && tweets.size() < 10) {
			Data curr = queue.poll();
			tweets.add(curr.tweet.id);
			next(queue, curr.rest);
		}

		return tweets;
	}

	/**
	 * Follower follows a followee.
	 * If the operation is invalid, it should be a no-op.
	 */
	public void follow(int followerId, int followeeId) {
		userToFollowee.computeIfAbsent(followerId, this::newHashSet).add(followeeId);
	}

	/**
	 * Follower unfollows a followee.
	 * If the operation is invalid, it should be a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		userToFollowee.computeIfAbsent(followerId, this::newHashSet).remove(followeeId);
	}

	private HashSet<Integer> newHashSet(Integer ignored) {
		return new HashSet<>();
	}

	private LinkedList<Tweet> newLinkedList(Integer ignored) {
		return new LinkedList<>();
	}

	private void next(Queue<Data> queue, Iterator<Tweet> iterator) {
		if (iterator.hasNext()) {
			queue.offer(new Data(iterator.next(), iterator));
		}
	}

	private class Tweet {
		private int id, time;

		private Tweet(int id, int time) {
			this.id = id;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Tweet{" +
					"id=" + id +
					", time=" + time +
					'}';
		}
	}

	private class Data implements Comparable<Data> {

		private Tweet tweet;
		private Iterator<Tweet> rest;

		private Data(Tweet twit, Iterator<Tweet> rest) {
			this.tweet = twit;
			this.rest = rest;
		}

		@Override
		public int compareTo(Data o) {
			return o.tweet.time - tweet.time;
		}

		@Override
		public String toString() {
			return "Pair{" +
					"twit=" + tweet +
					", rest=" + rest +
					'}';
		}
	}

}
