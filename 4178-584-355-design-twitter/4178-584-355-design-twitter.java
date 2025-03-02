class Twitter {

    private static int timestamp = 0; // timestamp to maintain order

    class Tweet {
        int tweetId;
        int time;
        Tweet next; // To maintain a linked list of tweets for each user (latest -> oldest)

        public Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.time = timestamp++;
            this.next = null;
        }
    }

    private Map<Integer, Set<Integer>> followingMap; // user -> followees
    private Map<Integer, Tweet> tweetsMap; // user -> tweet linked list (latest first)

    public Twitter() {
        followingMap = new HashMap<>();
        tweetsMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId);
        newTweet.next = tweetsMap.get(userId); // Insert at head
        tweetsMap.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        
        // Add user's own tweets
        if (tweetsMap.containsKey(userId)) {
            maxHeap.add(tweetsMap.get(userId));
        }

        // Add followees' tweets
        for (int followeeId : followingMap.getOrDefault(userId, new HashSet<>())) {
            if (tweetsMap.containsKey(followeeId)) {
                maxHeap.add(tweetsMap.get(followeeId));
            }
        }

        // Get the top 10 tweets
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet tweet = maxHeap.poll();
            result.add(tweet.tweetId);
            if (tweet.next != null) {
                maxHeap.add(tweet.next);
            }
            count++;
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // Can't follow self
        followingMap.putIfAbsent(followerId, new HashSet<>());
        followingMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followingMap.containsKey(followerId)) {
            followingMap.get(followerId).remove(followeeId);
        }
    }
}
