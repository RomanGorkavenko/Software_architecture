namespace ClinicDesctop
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            btnUpdate = new Button();
            listViewClients = new ListView();
            btnCreate = new Button();
            btnEdit = new Button();
            btnDelete = new Button();
            groupRBtn = new GroupBox();
            rBtnClients = new RadioButton();
            rBtnPets = new RadioButton();
            rBtnConsultations = new RadioButton();
            groupRBtn.SuspendLayout();
            SuspendLayout();
            // 
            // btnUpdate
            // 
            btnUpdate.Location = new Point(1206, 786);
            btnUpdate.Name = "btnUpdate";
            btnUpdate.Size = new Size(197, 205);
            btnUpdate.TabIndex = 2;
            btnUpdate.Text = "Обновить";
            btnUpdate.UseVisualStyleBackColor = true;
            btnUpdate.Click += btnUpdate_Click;
            // 
            // listViewClients
            // 
            listViewClients.Font = new Font("Segoe UI", 9F, FontStyle.Regular, GraphicsUnit.Point);
            listViewClients.FullRowSelect = true;
            listViewClients.GridLines = true;
            listViewClients.Location = new Point(12, 12);
            listViewClients.MultiSelect = false;
            listViewClients.Name = "listViewClients";
            listViewClients.Size = new Size(1391, 768);
            listViewClients.TabIndex = 1;
            listViewClients.UseCompatibleStateImageBehavior = false;
            listViewClients.View = View.Details;
            // 
            // btnCreate
            // 
            btnCreate.Location = new Point(1003, 786);
            btnCreate.Name = "btnCreate";
            btnCreate.Size = new Size(197, 205);
            btnCreate.TabIndex = 3;
            btnCreate.Text = "Создать";
            btnCreate.UseVisualStyleBackColor = true;
            btnCreate.Click += btnCreate_Click;
            // 
            // btnEdit
            // 
            btnEdit.Location = new Point(800, 786);
            btnEdit.Name = "btnEdit";
            btnEdit.Size = new Size(197, 205);
            btnEdit.TabIndex = 4;
            btnEdit.Text = "Изменить";
            btnEdit.UseVisualStyleBackColor = true;
            btnEdit.Click += btnEdit_Click;
            // 
            // btnDelete
            // 
            btnDelete.Location = new Point(597, 786);
            btnDelete.Name = "btnDelete";
            btnDelete.Size = new Size(197, 205);
            btnDelete.TabIndex = 5;
            btnDelete.Text = "Удалить";
            btnDelete.UseVisualStyleBackColor = true;
            btnDelete.Click += btnDelete_Click;
            // 
            // groupRBtn
            // 
            groupRBtn.Controls.Add(rBtnClients);
            groupRBtn.Controls.Add(rBtnPets);
            groupRBtn.Controls.Add(rBtnConsultations);
            groupRBtn.Location = new Point(12, 786);
            groupRBtn.Name = "groupRBtn";
            groupRBtn.Size = new Size(579, 205);
            groupRBtn.TabIndex = 6;
            groupRBtn.TabStop = false;
            groupRBtn.Text = "Выбор данных";
            // 
            // rBtnClients
            // 
            rBtnClients.AutoSize = true;
            rBtnClients.Location = new Point(289, 56);
            rBtnClients.Name = "rBtnClients";
            rBtnClients.Size = new Size(154, 41);
            rBtnClients.TabIndex = 2;
            rBtnClients.TabStop = true;
            rBtnClients.Text = "Клиенты";
            rBtnClients.UseVisualStyleBackColor = true;
            // 
            // rBtnPets
            // 
            rBtnPets.AutoSize = true;
            rBtnPets.Location = new Point(23, 128);
            rBtnPets.Name = "rBtnPets";
            rBtnPets.Size = new Size(164, 41);
            rBtnPets.TabIndex = 1;
            rBtnPets.TabStop = true;
            rBtnPets.Text = "Питомцы";
            rBtnPets.UseVisualStyleBackColor = true;
            // 
            // rBtnConsultations
            // 
            rBtnConsultations.AutoSize = true;
            rBtnConsultations.Location = new Point(23, 56);
            rBtnConsultations.Name = "rBtnConsultations";
            rBtnConsultations.Size = new Size(222, 41);
            rBtnConsultations.TabIndex = 0;
            rBtnConsultations.TabStop = true;
            rBtnConsultations.Text = "Консультации";
            rBtnConsultations.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(15F, 37F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1415, 1003);
            Controls.Add(groupRBtn);
            Controls.Add(btnDelete);
            Controls.Add(btnEdit);
            Controls.Add(btnCreate);
            Controls.Add(btnUpdate);
            Controls.Add(listViewClients);
            FormBorderStyle = FormBorderStyle.FixedSingle;
            MaximizeBox = false;
            Name = "Form1";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Моя клиника";
            groupRBtn.ResumeLayout(false);
            groupRBtn.PerformLayout();
            ResumeLayout(false);
        }

        #endregion
        private Button btnUpdate;
        private ListView listViewClients;
        private Button btnCreate;
        private Button btnEdit;
        private Button btnDelete;
        private GroupBox groupRBtn;
        private RadioButton rBtnPets;
        private RadioButton rBtnConsultations;
        private RadioButton rBtnClients;
    }
}