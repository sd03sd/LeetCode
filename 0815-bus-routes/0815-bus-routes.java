class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> busRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                busRoutes.putIfAbsent(routes[i][j], new ArrayList<>());
                busRoutes.get(routes[i][j]).add(i);
            }
        }

        Set<Integer> visitedBusNumber = new HashSet<>();
        Set<Integer> visitedStops = new HashSet<>();
        Queue<Integer> busStops = new LinkedList<>();

        busStops.add(source);
        visitedStops.add(source);

        int numberOfBuses = 0;

        while (!busStops.isEmpty()) {
            int size = busStops.size();

            for (int i = 0; i < size; i++) {
                int stop = busStops.poll();

                List<Integer> busNumber = busRoutes.get(stop);

                for (int number : busNumber) {
                    if (visitedBusNumber.contains(number)) {
                        continue;
                    }
                    visitedBusNumber.add(number);

                    for (int j = 0; j < routes[number].length; j++) {
                        int nextStop = routes[number][j];
                        if (!visitedStops.contains(nextStop)) {
                            busStops.add(nextStop);
                            visitedStops.add(nextStop);
                            if (nextStop == target) {
                                return numberOfBuses + 1;
                            }
                        }
                    }
                }
            }
            numberOfBuses++;
        }
        return -1;
    }
}