using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Liu
{
	public class Task
	{
		public Task(int id, int taskTime, int taksStartTime, int taskEndTime)
		{
			// TODO: Complete member initialization
			Id = id;
			Time = taskTime;
			StartTime = taksStartTime;
			ExpectEndTime = taskEndTime;
		}

		public int Id { get; set; }
		public int Time { get; set; }
		public int StartTime { get; set; }
		public int ExpectEndTime { get; set; }
		public int EndTime { get; set; }
		public int L { get; set; }
	}
}
