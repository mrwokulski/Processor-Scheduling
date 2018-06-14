namespace Liu
{
	partial class Form1
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

		#region Windows Form Designer generated code

		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.btnAddTask = new System.Windows.Forms.Button();
			this.btnCalculation = new System.Windows.Forms.Button();
			this.btnTestTasks = new System.Windows.Forms.Button();
			this.pictureBox1 = new System.Windows.Forms.PictureBox();
			this.taskView = new System.Windows.Forms.DataGridView();
			this.lblLMaxText = new System.Windows.Forms.Label();
			((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
			((System.ComponentModel.ISupportInitialize)(this.taskView)).BeginInit();
			this.SuspendLayout();
			// 
			// btnAddTask
			// 
			this.btnAddTask.Location = new System.Drawing.Point(12, 12);
			this.btnAddTask.Name = "btnAddTask";
			this.btnAddTask.Size = new System.Drawing.Size(75, 23);
			this.btnAddTask.TabIndex = 0;
			this.btnAddTask.Text = "Add task";
			this.btnAddTask.UseVisualStyleBackColor = true;
			this.btnAddTask.Click += new System.EventHandler(this.btnAddTask_Click);
			// 
			// btnCalculation
			// 
			this.btnCalculation.Location = new System.Drawing.Point(93, 12);
			this.btnCalculation.Name = "btnCalculation";
			this.btnCalculation.Size = new System.Drawing.Size(143, 23);
			this.btnCalculation.TabIndex = 1;
			this.btnCalculation.Text = "Calculate times for tasks";
			this.btnCalculation.UseVisualStyleBackColor = true;
			this.btnCalculation.Click += new System.EventHandler(this.btnCalculation_Click);
			// 
			// btnTestTasks
			// 
			this.btnTestTasks.Location = new System.Drawing.Point(242, 12);
			this.btnTestTasks.Name = "btnTestTasks";
			this.btnTestTasks.Size = new System.Drawing.Size(75, 23);
			this.btnTestTasks.TabIndex = 2;
			this.btnTestTasks.Text = "Test tasks";
			this.btnTestTasks.UseVisualStyleBackColor = true;
			this.btnTestTasks.Click += new System.EventHandler(this.btnTestTasks_Click);
			// 
			// pictureBox1
			// 
			this.pictureBox1.Location = new System.Drawing.Point(12, 570);
			this.pictureBox1.Name = "pictureBox1";
			this.pictureBox1.Size = new System.Drawing.Size(748, 67);
			this.pictureBox1.TabIndex = 3;
			this.pictureBox1.TabStop = false;
			// 
			// taskView
			// 
			this.taskView.AllowUserToAddRows = false;
			this.taskView.AllowUserToDeleteRows = false;
			this.taskView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
			this.taskView.Location = new System.Drawing.Point(12, 338);
			this.taskView.Name = "taskView";
			this.taskView.ReadOnly = true;
			this.taskView.Size = new System.Drawing.Size(761, 200);
			this.taskView.TabIndex = 4;
			// 
			// lblLMaxText
			// 
			this.lblLMaxText.AutoSize = true;
			this.lblLMaxText.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
			this.lblLMaxText.ForeColor = System.Drawing.Color.Green;
			this.lblLMaxText.Location = new System.Drawing.Point(779, 338);
			this.lblLMaxText.Name = "lblLMaxText";
			this.lblLMaxText.Size = new System.Drawing.Size(61, 18);
			this.lblLMaxText.TabIndex = 5;
			this.lblLMaxText.Text = "Lmax = ";
			this.lblLMaxText.Visible = false;
			// 
			// Form1
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(913, 675);
			this.Controls.Add(this.lblLMaxText);
			this.Controls.Add(this.taskView);
			this.Controls.Add(this.pictureBox1);
			this.Controls.Add(this.btnTestTasks);
			this.Controls.Add(this.btnCalculation);
			this.Controls.Add(this.btnAddTask);
			this.Name = "Form1";
			this.Text = "Form1";
			((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
			((System.ComponentModel.ISupportInitialize)(this.taskView)).EndInit();
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Button btnAddTask;
		private System.Windows.Forms.Button btnCalculation;
		private System.Windows.Forms.Button btnTestTasks;
		private System.Windows.Forms.PictureBox pictureBox1;
		private System.Windows.Forms.DataGridView taskView;
		private System.Windows.Forms.Label lblLMaxText;
	}
}

