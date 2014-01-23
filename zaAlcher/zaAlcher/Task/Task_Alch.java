package zaAlcher.Task;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Random;
import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.Item;

import zaAlcher.ZaAlcher;
@SuppressWarnings("deprecation")
public class Task_Alch extends Task 
{
	ZaAlcher alcher;
	public Task_Alch(MethodContext ctx,ZaAlcher alcher) 
	{
		super(ctx);
		this.alcher = alcher;
		delay = new Timer(Random.nextInt(3000,3500));
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
		ctx.keyboard.send("5");
		final Item item = ctx.backpack.select().id(alcher.ItemID).poll();
		item.click();
	}

}
