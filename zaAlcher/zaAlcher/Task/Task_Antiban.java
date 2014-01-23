package zaAlcher.Task;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Random;
import org.powerbot.script.util.Timer;

@SuppressWarnings("deprecation")
public class Task_Antiban extends Task 
{
	Timer delay;
	public Task_Antiban(MethodContext ctx) 
	{
		super(ctx);
		delay = new Timer(Random.nextInt(5000, 15000));
	}

	@Override
	public boolean activate() 
	{
		if(delay.isRunning())
			return false;
		
		
		delay.reset();
		return true;
	}

	@Override
	public void execute()
	{
		ctx.camera.setAngle(Random.nextInt(40, 250));	

	}

}
