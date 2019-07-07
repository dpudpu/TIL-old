package domain.reward;

import domain.ladder.Position;

import java.util.HashMap;
import java.util.Map;

public class Rewards {
    private Map<Position, RewardName> rewards;

    public Rewards(final String rewardNames) {
        rewards = new HashMap<>();

        //TODO Refactor
        int index = 0;
        for (final String name : rewardNames.split(",")) {
            final Position position = Position.from(index++);
            final RewardName rewardName = new RewardName(name.trim());
            rewards.put(position, rewardName);
        }
    }

    public RewardName get(Position position){
        return rewards.get(position);
    }

    public int size(){
        return rewards.size();
    }
}
