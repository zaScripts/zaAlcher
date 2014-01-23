package zaAlcher.Task;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Random;
import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.Item;

import zaAlcher.ZaAlcher;
@SuppressWarnings("deprecation")
public class Task_Alch extends Task 
{
	public Task_Alch(MethodContext ctx) 
	{
		super(ctx);


	}


	@Override
	public boolean activate() 
	{
		if(ctx.players.local().getAnimation()==-1)
			return true;
		return false;
	}

	@Override
	public void execute()
	{
		ctx.keyboard.send("5");
		final Item item = ctx.backpack.select().id(ZaAlcher.ItemID).poll();
		item.click();
	}

}
