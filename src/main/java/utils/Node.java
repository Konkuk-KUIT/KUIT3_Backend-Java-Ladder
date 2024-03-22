package utils;

import static constant.Direction.LEFT;
import static constant.Direction.RIGHT;

import constant.Direction;

public class Node {

  private Direction direction;

  private Node(Direction direction) {
    this.direction = direction;
  }

  public Position move(Position position) {
    if (isLeft())
      return position.prev();
    if (isRight())
      return position.next();
    return position;
  }

  public void drawLeftLine() {
    this.direction = LEFT;
  }

  public void drawRightLine() {
    this.direction = RIGHT;
  }

  public boolean isLeft() {
    return direction == LEFT;
  }

  public boolean isRight() {
    return direction == RIGHT;
  }

  public static Node of(Direction direction) {
    return new Node(direction);
  }

  public Direction getDirection() {
    return this.direction;
  }
}
