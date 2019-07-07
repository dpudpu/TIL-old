package domain.reward;

import domain.ladder.Position;

import java.util.HashMap;
import java.util.Map;

public class Rewards {
    private Map<Position, Reward> rewards;

    public Rewards(final String rewardNames) {
        rewards = new HashMap<>();

        //TODO Refactor
        int index = 0;
        for (final String name : rewardNames.split(",")) {
            final Position position = Position.from(index++);
            final Reward reward = new Reward(name.trim());
            rewards.put(position, reward);
        }
    }

    public Reward get(Position position){
        return rewards.get(position);
    }

    public int size(){
        return rewards.size();
    }
}
