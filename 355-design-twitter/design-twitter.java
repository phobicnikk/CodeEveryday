class Twitter {
    // LinkedList to store tweets chronologically
    ListNode tweets;
    // Keep a track of followers for each user
    HashMap<Integer, ArrayList<Integer>> followings;

    public Twitter() {
        followings = new HashMap<>();
    }
    
    // Create a new node, and insert at beginning (head)
    public void postTweet(int userId, int tweetId) {
        if(tweets==null) {
            tweets = new ListNode(new Pair<Integer, Integer>(userId, tweetId));
        } else {
            ListNode node = new ListNode(new Pair<Integer, Integer>(userId, tweetId));
            node.next = tweets;
            tweets = node;
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<Integer> followingList = followings.getOrDefault(userId, null);
        if(followingList==null) {
            // Do not return (since tweets posted by self are to be included)
            followingList = new ArrayList<Integer>();
        }

        ListNode tweet = tweets;
        while(ans.size()!=10 && tweet!=null) {
            // check if user follows the poster
            if(followingList.contains(tweet.val.getKey()) || userId == tweet.val.getKey())
                ans.add(tweet.val.getValue());
            tweet = tweet.next;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        ArrayList<Integer> followList = followings.getOrDefault(followerId, null);
        if(followList==null) {
            followings.put(followerId, new ArrayList<Integer>());
        }
        followings.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        ArrayList<Integer> followList = followings.getOrDefault(followerId, null);
        if(followList==null) return;

        // Iterate and remove followee
        for(int i=0; i<followList.size(); i++) {
            if(followList.get(i)==followeeId) {
                followList.remove(i);
                break;
            }
        }
    }
}

// Helper
class ListNode {
    // To store (userId, tweet)
    Pair<Integer, Integer> val;
    ListNode next;

    public ListNode(Pair<Integer, Integer> val) {
        this.val = val;
        this.next = null;
    }
}