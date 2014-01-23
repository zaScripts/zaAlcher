package zaAlcher.Task;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.MethodProvider;
import org.powerbot.script.util.Timer;

@SuppressWarnings("deprecation")
public abstract class Task extends MethodProvider
{
	public Timer delay;
	public Task(MethodContext ctx)
	{
		super(ctx);
		
	}
	
	public abstract boolean activate();
	public abstract void execute();

}
