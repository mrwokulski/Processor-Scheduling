namespace Liu
{
	partial class AddTask
	{
		/// <summary> 
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.IContainer components = null;

		/// <summary> 
		/// Clean up any resources being used.
		/// </summary>
		/// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
		protected override void Dispose(bool disposing)
		{
			if (disposing && (components != null))
			{
				components.Dispose();
			}
			base.Dispose(disposing);
		}

		#region Component Designer generated code

		/// <summary> 
		/// Required method for Designer support - do not modify 
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.label1 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.label3 = new System.Windows.Forms.Label();
			this.tbTaskTime = new System.Windows.Forms.TextBox();
			this.tbStartTime = new System.Windows.Forms.TextBox();
			this.tbExpectEndTime = new System.Windows.Forms.TextBox();
			this.lblErrorTime = new System.Windows.Forms.Label();
			this.lblErrorStartTime = new System.Windows.Forms.Label();
			this.lblErrorEndTime = new System.Windows.Forms.Label();
			this.btnAdd = new System.Windows.Forms.Button();
			this.btnCancel = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Location = new System.Drawing.Point(4, 47);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(56, 13);
			this.label1.TabIndex = 0;
			this.label1.Text = "Task time:";
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Location = new System.Drawing.Point(4, 85);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(76, 13);
			this.label2.TabIndex = 1;
			this.label2.Text = "Task start time";
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.Location = new System.Drawing.Point(4, 123);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(121, 13);
			this.label3.TabIndex = 2;
			this.label3.Text = "Task expected end time";
			// 
			// tbTaskTime
			// 
			this.tbTaskTime.Location = new System.Drawing.Point(130, 44);
			this.tbTaskTime.Name = "tbTaskTime";
			this.tbTaskTime.Size = new System.Drawing.Size(100, 20);
			this.tbTaskTime.TabIndex = 3;
			// 
			// tbStartTime
			// 
			this.tbStartTime.Location = new System.Drawing.Point(130, 82);
			this.tbStartTime.Name = "tbStartTime";
			this.tbStartTime.Size = new System.Drawing.Size(100, 20);
			this.tbStartTime.TabIndex = 4;
			// 
			// tbExpectEndTime
			// 
			this.tbExpectEndTime.Location = new System.Drawing.Point(130, 120);
			this.tbExpectEndTime.Name = "tbExpectEndTime";
			this.tbExpectEndTime.Size = new System.Drawing.Size(100, 20);
			this.tbExpectEndTime.TabIndex = 5;
			// 
			// lblErrorTime
			// 
			this.lblErrorTime.AutoSize = true;
			this.lblErrorTime.Location = new System.Drawing.Point(128, 67);
			this.lblErrorTime.Name = "lblErrorTime";
			this.lblErrorTime.Size = new System.Drawing.Size(0, 13);
			this.lblErrorTime.TabIndex = 6;
			this.lblErrorTime.Visible = false;
			// 
			// lblErrorStartTime
			// 
			this.lblErrorStartTime.AutoSize = true;
			this.lblErrorStartTime.Location = new System.Drawing.Point(128, 105);
			this.lblErrorStartTime.Name = "lblErrorStartTime";
			this.lblErrorStartTime.Size = new System.Drawing.Size(0, 13);
			this.lblErrorStartTime.TabIndex = 7;
			this.lblErrorStartTime.Visible = false;
			// 
			// lblErrorEndTime
			// 
			this.lblErrorEndTime.AutoSize = true;
			this.lblErrorEndTime.ForeColor = System.Drawing.Color.Red;
			this.lblErrorEndTime.Location = new System.Drawing.Point(128, 143);
			this.lblErrorEndTime.Name = "lblErrorEndTime";
			this.lblErrorEndTime.Size = new System.Drawing.Size(0, 13);
			this.lblErrorEndTime.TabIndex = 8;
			this.lblErrorEndTime.Visible = false;
			// 
			// btnAdd
			// 
			this.btnAdd.Location = new System.Drawing.Point(36, 146);
			this.btnAdd.Name = "btnAdd";
			this.btnAdd.Size = new System.Drawing.Size(75, 23);
			this.btnAdd.TabIndex = 9;
			this.btnAdd.Text = "Add task";
			this.btnAdd.UseVisualStyleBackColor = true;
			this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
			// 
			// btnCancel
			// 
			this.btnCancel.Location = new System.Drawing.Point(130, 146);
			this.btnCancel.Name = "btnCancel";
			this.btnCancel.Size = new System.Drawing.Size(75, 23);
			this.btnCancel.TabIndex = 10;
			this.btnCancel.Text = "Cancel";
			this.btnCancel.UseVisualStyleBackColor = true;
			this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
			// 
			// AddTask
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.Controls.Add(this.btnCancel);
			this.Controls.Add(this.btnAdd);
			this.Controls.Add(this.lblErrorEndTime);
			this.Controls.Add(this.lblErrorStartTime);
			this.Controls.Add(this.lblErrorTime);
			this.Controls.Add(this.tbExpectEndTime);
			this.Controls.Add(this.tbStartTime);
			this.Controls.Add(this.tbTaskTime);
			this.Controls.Add(this.label3);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.label1);
			this.Name = "AddTask";
			this.Size = new System.Drawing.Size(327, 333);
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.TextBox tbTaskTime;
		private System.Windows.Forms.TextBox tbStartTime;
		private System.Windows.Forms.TextBox tbExpectEndTime;
		private System.Windows.Forms.Label lblErrorTime;
		private System.Windows.Forms.Label lblErrorStartTime;
		private System.Windows.Forms.Label lblErrorEndTime;
		private System.Windows.Forms.Button btnAdd;
		private System.Windows.Forms.Button btnCancel;
	}
}
