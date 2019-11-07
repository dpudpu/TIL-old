package com.nplusone.nplus.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TeamController {
    private final TeamRepository teamRepository;

    public TeamController(final TeamRepository teamRepository) {
        this.teamRepository = teamRepository;

    }

    @GetMapping("/list")
    public String list() {
        final List<Team> teams = teamRepository.findAll();

        for (final Team team : teams) {
            System.out.println("----------------------------------");
            for (final Member member : team.getMembers()) {
                System.out.println(team.getName() + " / " + member.getName());
            }
        }

        return "ll";
    }
}
