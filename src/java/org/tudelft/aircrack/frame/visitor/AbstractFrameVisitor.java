package org.tudelft.aircrack.frame.visitor;

import org.tudelft.aircrack.frame.Frame;
import org.tudelft.aircrack.frame.control.*;
import org.tudelft.aircrack.frame.data.DataFrame;
import org.tudelft.aircrack.frame.management.*;

public class AbstractFrameVisitor implements FrameVisitor
{

	@Override
	public void visit(Frame frame)
	{
		// Root
	}

	@Override
	public void visit(ControlFrame frame)
	{
		visit((Frame)frame);
	}

	@Override
	public void visit(DataFrame frame)
	{
		visit((Frame)frame);
	}

	@Override
	public void visit(ManagementFrame frame)
	{
		visit((Frame)frame);
	}

	@Override
	public void visit(RaFrame frame)
	{
		visit((ControlFrame)frame);
	}

	@Override
	public void visit(AckFrame frame)
	{
		visit((ControlFrame)frame);
	}

	@Override
	public void visit(CtsFrame frame)
	{
		visit((ControlFrame)frame);
	}

	@Override
	public void visit(RaTaFrame frame)
	{
		visit((ControlFrame)frame);
	}

	@Override
	public void visit(BlockAckOrRequestFrame frame)
	{
		visit((RaTaFrame)frame);
	}

	@Override
	public void visit(CfEndFrame frame)
	{
		visit((RaTaFrame)frame);
	}

	@Override
	public void visit(PsPollFrame frame)
	{
		visit((RaTaFrame)frame);
	}

	@Override
	public void visit(RtsFrame frame)
	{
		visit((RaTaFrame)frame);
	}

	@Override
	public void visit(BlockAckFrame frame)
	{
		visit((BlockAckOrRequestFrame)frame);
	}

	@Override
	public void visit(BlockAckRequestFrame frame)
	{
		visit((BlockAckOrRequestFrame)frame);
	}

	@Override
	public void visit(CfEndCfAckFrame frame)
	{
		visit((CfEndFrame)frame);
	}

	@Override
	public void visit(BeaconOrProbeResponse frame)
	{
		visit((ManagementFrame)frame);
	}

	@Override
	public void visit(ProbeRequest frame)
	{
		visit((ManagementFrame)frame);
	}

	@Override
	public void visit(Beacon frame)
	{
		visit((BeaconOrProbeResponse )frame);
	}

	@Override
	public void visit(ProbeResponse frame)
	{
		visit((BeaconOrProbeResponse )frame);
	}

}
