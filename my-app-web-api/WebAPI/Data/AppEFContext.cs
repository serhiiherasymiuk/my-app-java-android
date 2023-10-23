using Microsoft.EntityFrameworkCore;
using WebAPI.data.Entities;

namespace WebAPI.Data
{
    public class AppEFContext : DbContext
    {
        public AppEFContext(DbContextOptions<AppEFContext> options)
            : base(options) { }

        public DbSet<CategoryEntity> Categories { get; set; }
    }
}
