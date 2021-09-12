package gameboilerplate;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Game {
  private ArrayList<DisplayableEntity> entities = new ArrayList<>();
  private Frame f;
  public Game(int width, int height, Color bgColor){
    f = new Frame(width, height, bgColor, entities);
  }
  public ArrayList<DisplayableEntity> getEntities() {
    return entities;
  }
  public void setEntities(ArrayList<DisplayableEntity> entities) {
    this.entities = entities;
  }
  public void addEntity(DisplayableEntity entity){
    this.entities.add(entity);
  }
  public void loop(){
    f.loop();
  }

  private class Frame extends JFrame {
    Frame(int width, int height, Color bgColor, ArrayList<DisplayableEntity> entities){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Init init = new Init(width, height, entities);
      setContentPane(init);
      pack();
      setBackground(bgColor);
      setVisible(true);
    }
    void loop(){
      while (true){
        Instant start = Instant.now();
        repaint();
        Instant end = Instant.now();
        long timeToPaint = Duration.between(start, end).toMillis();
        try {
          Thread.sleep(60 - timeToPaint);
        } catch (Exception e){
          System.out.println(e);
        }
      }
    }
  }
  private class Init extends JPanel{
    Init(int width, int height, ArrayList<DisplayableEntity> entities){
      setPreferredSize(new Dimension(width, height));
      setFocusable(true);
      setOpaque(true);
      requestFocus();
      // User game object here

      // Keys

      }
    @Override
    public void paint(Graphics g) {
      // User objects paint
      for (DisplayableEntity entity: entities){
        entity.display(g);
      }
    }
  }
}
