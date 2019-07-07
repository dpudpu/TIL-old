package domain.ladder;

import domain.game.Result;
import domain.player.Player;
import domain.player.Players;
import domain.reward.Reward;
import domain.reward.Rewards;

import java.util.*;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = new ArrayList<>(Objects.requireNonNull(lines));
        validateSize(lines);
    }

    private void validateSize(final List<Line> lines) {
        if (lines.size() < Height.MIN_RANGE) {
            throw new IllegalArgumentException("사다리 높이는 " + Height.MIN_RANGE + "이상이야 합니다");
        }
    }

    public Result createResult(final Players players, final Rewards rewards) {
        validateResult(players, rewards);
        Map<Player, Reward> results = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            Position position = Position.from(i);
            Player player = players.get(position);
            for (int j = 0; j < players.size(); j++) {
                position = lines.get(j).move(position);
            }
            Reward reward = rewards.get(position);
            results.put(player, reward);
        }
        return new Result(results);
    }

    private void validateResult(final Players players, final Rewards rewards) {
        if (players.size() != rewards.size()) {
            throw new IllegalArgumentException("사람 수와 보상의 수가 다릅니다.");
        }
    }
}
