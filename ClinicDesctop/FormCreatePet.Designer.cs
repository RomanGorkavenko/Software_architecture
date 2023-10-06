namespace ClinicDesctop
{
    partial class FormCreatePet
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
            PetId = new NumericUpDown();
            PetIdTitle = new Label();
            dateTimeBirthday = new DateTimePicker();
            titleBirthday = new Label();
            cancel = new Button();
            save = new Button();
            nameTitle = new Label();
            name = new TextBox();
            ClientId = new NumericUpDown();
            ClientIdTitle = new Label();
            ((System.ComponentModel.ISupportInitialize)PetId).BeginInit();
            ((System.ComponentModel.ISupportInitialize)ClientId).BeginInit();
            SuspendLayout();
            // 
            // PetId
            // 
            PetId.Location = new Point(390, 37);
            PetId.Maximum = new decimal(new int[] { 1000000, 0, 0, 0 });
            PetId.Minimum = new decimal(new int[] { 1, 0, 0, 0 });
            PetId.Name = "PetId";
            PetId.Size = new Size(196, 43);
            PetId.TabIndex = 33;
            PetId.Value = new decimal(new int[] { 1, 0, 0, 0 });
            // 
            // PetIdTitle
            // 
            PetIdTitle.AutoSize = true;
            PetIdTitle.Location = new Point(33, 23);
            PetIdTitle.Name = "PetIdTitle";
            PetIdTitle.Size = new Size(317, 74);
            PetIdTitle.TabIndex = 32;
            PetIdTitle.Text = "Введите № питомца,\r\nкорого хотите обновить\r\n";
            PetIdTitle.TextAlign = ContentAlignment.TopCenter;
            // 
            // dateTimeBirthday
            // 
            dateTimeBirthday.CalendarFont = new Font("Segoe UI Semibold", 10F, FontStyle.Bold, GraphicsUnit.Point);
            dateTimeBirthday.Font = new Font("Segoe UI Semibold", 10F, FontStyle.Bold, GraphicsUnit.Point);
            dateTimeBirthday.Location = new Point(390, 273);
            dateTimeBirthday.Name = "dateTimeBirthday";
            dateTimeBirthday.Size = new Size(389, 47);
            dateTimeBirthday.TabIndex = 31;
            // 
            // titleBirthday
            // 
            titleBirthday.AutoSize = true;
            titleBirthday.Location = new Point(57, 261);
            titleBirthday.Name = "titleBirthday";
            titleBirthday.Size = new Size(259, 74);
            titleBirthday.TabIndex = 28;
            titleBirthday.Text = "Введите дату\r\nрождения питомца";
            titleBirthday.TextAlign = ContentAlignment.TopCenter;
            // 
            // cancel
            // 
            cancel.Location = new Point(405, 384);
            cancel.Name = "cancel";
            cancel.Size = new Size(169, 52);
            cancel.TabIndex = 23;
            cancel.Text = "Отмена";
            cancel.UseVisualStyleBackColor = true;
            cancel.Click += cancel_Click;
            // 
            // save
            // 
            save.Location = new Point(610, 384);
            save.Name = "save";
            save.Size = new Size(169, 52);
            save.TabIndex = 22;
            save.Text = "Сохранить";
            save.UseVisualStyleBackColor = true;
            save.Click += save_Click;
            // 
            // nameTitle
            // 
            nameTitle.AutoSize = true;
            nameTitle.Location = new Point(48, 191);
            nameTitle.Name = "nameTitle";
            nameTitle.Size = new Size(287, 37);
            nameTitle.TabIndex = 21;
            nameTitle.Text = "Введите имя питомца";
            // 
            // name
            // 
            name.Font = new Font("Segoe UI Semibold", 10F, FontStyle.Bold, GraphicsUnit.Point);
            name.Location = new Point(390, 185);
            name.Name = "name";
            name.Size = new Size(389, 47);
            name.TabIndex = 20;
            name.Tag = "";
            name.Text = "Имя";
            // 
            // ClientId
            // 
            ClientId.Location = new Point(390, 121);
            ClientId.Maximum = new decimal(new int[] { 1000000, 0, 0, 0 });
            ClientId.Minimum = new decimal(new int[] { 1, 0, 0, 0 });
            ClientId.Name = "ClientId";
            ClientId.Size = new Size(196, 43);
            ClientId.TabIndex = 35;
            ClientId.Value = new decimal(new int[] { 1, 0, 0, 0 });
            // 
            // ClientIdTitle
            // 
            ClientIdTitle.AutoSize = true;
            ClientIdTitle.Location = new Point(58, 123);
            ClientIdTitle.Name = "ClientIdTitle";
            ClientIdTitle.Size = new Size(258, 37);
            ClientIdTitle.TabIndex = 34;
            ClientIdTitle.Text = "Введите № клиента\r\n";
            ClientIdTitle.TextAlign = ContentAlignment.TopCenter;
            // 
            // FormCreatePet
            // 
            AutoScaleDimensions = new SizeF(15F, 37F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = SystemColors.ControlLight;
            ClientSize = new Size(837, 467);
            Controls.Add(ClientId);
            Controls.Add(ClientIdTitle);
            Controls.Add(PetId);
            Controls.Add(PetIdTitle);
            Controls.Add(dateTimeBirthday);
            Controls.Add(titleBirthday);
            Controls.Add(cancel);
            Controls.Add(save);
            Controls.Add(nameTitle);
            Controls.Add(name);
            FormBorderStyle = FormBorderStyle.None;
            Name = "FormCreatePet";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "FormCreatePet";
            ((System.ComponentModel.ISupportInitialize)PetId).EndInit();
            ((System.ComponentModel.ISupportInitialize)ClientId).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private NumericUpDown PetId;
        private Label PetIdTitle;
        private DateTimePicker dateTimeBirthday;
        private Label titleBirthday;
        private Button cancel;
        private Button save;
        private Label nameTitle;
        private TextBox name;
        private NumericUpDown ClientId;
        private Label ClientIdTitle;
    }
}