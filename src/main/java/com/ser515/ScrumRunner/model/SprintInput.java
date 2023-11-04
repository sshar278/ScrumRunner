package com.ser515.ScrumRunner.model;

public class SprintInput {
    private String name;
    private int noOfSprints;
    private int sprintDuration;
    private int teamCapacity;
    private String roleAssignment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfSprints() {
        return noOfSprints;
    }

    public void setNoOfSprints(int noOfSprints) {
        this.noOfSprints = noOfSprints;
    }

    public int getSprintDuration() {
        return sprintDuration;
    }

    public void setSprintDuration(int sprintDuration) {
        this.sprintDuration = sprintDuration;
    }

    public int getTeamCapacity() {
        return teamCapacity;
    }

    public void setTeamCapacity(int teamCapacity) {
        this.teamCapacity = teamCapacity;
    }

    public String getRoleAssignment() {
        return roleAssignment;
    }

    public void setRoleAssignment(String roleAssignment) {
        this.roleAssignment = roleAssignment;
    }

    @Override
    public String toString() {
        return "SprintInput{" +
                "name='" + name + '\'' +
                ", noOfSprints=" + noOfSprints +
                ", sprintDuration=" + sprintDuration +
                ", teamCapacity=" + teamCapacity +
                ", roleAssignment='" + roleAssignment + '\'' +
                '}';
    }
}