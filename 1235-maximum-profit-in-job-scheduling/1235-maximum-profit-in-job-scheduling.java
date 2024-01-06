class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int numJobs = profit.length;
        Job[] jobs = new Job[numJobs];

        for(int i = 0; i < numJobs; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));

        int[] dp = new int[numJobs+1];

        for(int i = 0; i < numJobs; i++){
            int startTimeValue = jobs[i].startTime;
            int endTimeValue = jobs[i].endTime;
            int profitValue = jobs[i].profit;

            int lastIndexConflict = upperBound(jobs, i, startTimeValue);
            dp[i+1] = Math.max(dp[i], dp[lastIndexConflict] + profitValue);;

        }

        return dp[numJobs];
    }

    private int upperBound(Job[] jobs, int endTime, int target){
        int low = 0;
        int high = endTime;

        while(low < high){
            int mid = (low + high) / 2;
            if(jobs[mid].endTime <= target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public static class Job{
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime,int endTime,int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}