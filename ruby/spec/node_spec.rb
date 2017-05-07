require 'node'

RSpec.describe Node do
    it "inits a node with name and priority" do
       node = Node.new("Walter", 21)
       expect(node.name).to eq "Walter"
       expect(node.priority).to eq 21
    end
end
