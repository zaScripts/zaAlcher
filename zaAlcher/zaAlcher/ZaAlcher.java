package zaAlcher;

import gui.Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.powerbot.event.MessageEvent;
import org.powerbot.event.MessageListener;
import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.methods.Hud;
import org.powerbot.script.methods.Skills;

import zaAlcher.Task.Task;
import zaAlcher.Task.Task_Alch;
import zaAlcher.Task.Task_Antiban;


@Manifest (authors={"zaScript"} , name = "zaAlcher" , description = "Basic high alchemy script")

public class ZaAlcher extends PollingScript implements MessageListener, PaintListener{

	private ArrayList<Task> taskList = new ArrayList<Task>();
	
	public int ItemID;
	public boolean started = false;
	
	private int startingExp;
	private int startingLevel;
	public long startingTime;

	
	
	@Override
	public void start()
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
					Gui window = new Gui(ZaAlcher.this);
					window.frmZaalcher.setVisible(true);
			}
		});
		taskList.add(new Task_Alch(ctx,this));
		taskList.add(new Task_Antiban(ctx));
		
		startingExp = ctx.skills.getExperience(Skills.MAGIC);
		startingLevel = ctx.skills.getLevel(Skills.MAGIC);
		
	}
	@Override
	public int poll() 
	{
		if(!started)
			return 500;
		
		
		if(!ctx.hud.isOpen(Hud.Window.BACKPACK))
			ctx.hud.open(Hud.Window.BACKPACK);
		if(!ctx.hud.isVisible(Hud.Window.BACKPACK))
			ctx.hud.view(Hud.Window.BACKPACK);
		
		
		
		for(Task task: taskList)
		{
			if(task.activate())
				task.execute();
		}
		
		return 100;
	}
	@Override
	public void repaint(Graphics g) 
	{
		if(!started)
			return;
		int expGained = ctx.skills.getExperience(Skills.MAGIC) - startingExp;
		int currentLevel = ctx.skills.getLevel(Skills.MAGIC);
		int levelsGained = currentLevel - startingLevel;
		long currentTime = System.currentTimeMillis();
		long runTime = currentTime-startingTime;
		long expPerHour = (expGained * 3600000L)/runTime;


		
		g.setColor(new Color(0,0,0,180));
		g.fillRect(0, 0, 400, 65);
		g.setColor(Color.WHITE);
		g.setFont(new Font(("Tahoma"),Font.PLAIN,12));
		g.drawString("Run Time: "+getRunTimeString(runTime),10,20);
		g.drawString("Experience: "+expGained,170,20);
		g.drawString("Exp/Hour: "+expPerHour,10,40);
		g.drawString("Level: "+currentLevel+"+"+levelsGained,170 ,40 );
		
		
	}
	
	private String getRunTimeString(long millis)
	{
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
        return hours+"h "+minutes+"m "+seconds+"s";
	}
	@Override
	public void messaged(MessageEvent msg) 
	{
		
		
	}
	

	



}