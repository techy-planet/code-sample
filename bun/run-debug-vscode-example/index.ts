const server = Bun.serve({
    port: 3000,
    fetch(req) {
      var str = "Hello Bunny!!";
      return new Response(`${str}`);
    },
  });
  
  console.log(`Listening on http://localhost:${server.port}...`);
  