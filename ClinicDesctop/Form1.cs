using ClinicServiceNamespace;

namespace ClinicDesctop
{
    public partial class Form1 : Form
    {
        private ClinicClient clinicClient = new ClinicClient("http://localhost:5299/", new HttpClient());

        private const int _clientData = 2;

        private const int _petData = 3;

        private const int _consultationData = 1;

        public Form1()
        {
            InitializeComponent();

            rBtnConsultations.Checked = true;
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            if (rBtnClients.Checked)
            {
                clientsUpdateList(sender, e);
            }
            if (rBtnPets.Checked)
            {
                petsUpdateList(sender, e);
            }
            if (rBtnConsultations.Checked)
            {
                consultationsUpdateList(sender, e);
            }
        }

        private void clientsUpdateList(object sender, EventArgs e)
        {

            ICollection<Client> clients = clinicClient.ClientGetAllAsync().Result;

            listViewClients.Items.Clear();

            listViewClients.Columns.Clear();

            listViewClients.Columns.Add("№", 60, HorizontalAlignment.Left);
            listViewClients.Columns.Add("Фамилия", 400, HorizontalAlignment.Left);
            listViewClients.Columns.Add("Имя", 200, HorizontalAlignment.Left);
            listViewClients.Columns.Add("Отчество", 400, HorizontalAlignment.Left);
            listViewClients.Columns.Add("Дата рождения", 331, HorizontalAlignment.Left);

            foreach (Client client in clients)
            {
                ListViewItem item = new ListViewItem();

                item.Text = client.ClientId.ToString();

                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.SurName
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.FirstName
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.Patronymic
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.Birthday.Date.ToString()
                });
                listViewClients.Items.Add(item);
            }
        }

        private void petsUpdateList(object sender, EventArgs e)
        {

            ICollection<Pet> pets = clinicClient.PetGetAllAsync().Result;

            listViewClients.Items.Clear();

            listViewClients.Columns.Clear();

            listViewClients.Columns.Add("№", 60, HorizontalAlignment.Left);
            listViewClients.Columns.Add("Имя", 200, HorizontalAlignment.Left);
            listViewClients.Columns.Add("Имя Владельца", 400, HorizontalAlignment.Left);
            listViewClients.Columns.Add("Фамилия Владельца", 400, HorizontalAlignment.Left);
            listViewClients.Columns.Add("Дата рождения", 331, HorizontalAlignment.Left);

            foreach (Pet pet in pets)
            {
                ListViewItem item = new ListViewItem();

                item.Text = pet.PetId.ToString();

                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = pet.Name
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = clinicClient.ClientGetByIdAsync(pet.ClientId).Result.FirstName
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = clinicClient.ClientGetByIdAsync(pet.ClientId).Result.SurName
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = pet.Birthday.Date.ToString()
                });
                listViewClients.Items.Add(item);
            }
        }

        private void consultationsUpdateList(object sender, EventArgs e)
        {

            ICollection<Consultation> consultations = clinicClient.ConsultationGetAllAsync().Result;

            listViewClients.Items.Clear();

            listViewClients.Columns.Clear();

            listViewClients.Columns.Add("№", 60, HorizontalAlignment.Left);
            listViewClients.Columns.Add("Имя Владельца", 300, HorizontalAlignment.Left);
            listViewClients.Columns.Add("Имя Питомца", 300, HorizontalAlignment.Left);
            listViewClients.Columns.Add("Дата консультации", 331, HorizontalAlignment.Left);
            listViewClients.Columns.Add("Описание", 400, HorizontalAlignment.Left);

            foreach (Consultation consultation in consultations)
            {
                ListViewItem item = new ListViewItem();

                item.Text = consultation.ConsultationId.ToString();

                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = clinicClient.ClientGetByIdAsync(consultation.ClientId).Result.FirstName
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = clinicClient.PetGetByIdAsync(consultation.PetId).Result.Name
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = consultation.ConsultationDate.DateTime.ToString()
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = consultation.Description
                });
                listViewClients.Items.Add(item);
            }
        }

        private void btnCreate_Click(object sender, EventArgs e)
        {
            if (rBtnClients.Checked)
            {
                FormCreateClient form = new FormCreateClient(false);
                form.ShowDialog();
            }
            if (rBtnPets.Checked)
            {
                FormCreatePet form = new FormCreatePet(false);
                form.ShowDialog();
            }
            if (rBtnConsultations.Checked)
            {
                FormCreateConsultation form = new FormCreateConsultation(false);
                form.ShowDialog();
            }
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (rBtnClients.Checked)
            {
                Delete form = new Delete(_clientData);
                form.ShowDialog();
            }
            if (rBtnPets.Checked)
            {
                Delete form = new Delete(_petData);
                form.ShowDialog();
            }
            if (rBtnConsultations.Checked)
            {
                Delete form = new Delete(_consultationData);
                form.ShowDialog();
            }
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            if (rBtnClients.Checked)
            {
                FormCreateClient form = new FormCreateClient(true);
                form.ShowDialog();
            }
            if (rBtnPets.Checked)
            {
                FormCreatePet form = new FormCreatePet(true);
                form.ShowDialog();
            }
            if (rBtnConsultations.Checked)
            {
                FormCreateConsultation form = new FormCreateConsultation(true);
                form.ShowDialog();
            }
        }
    }
}