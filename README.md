# N-ary Tree LCA & LDCA Finder

This repository contains code for finding the Lowest Common Ancestor (LCA) and Lowest Dominating Common Ancestors (LDCAs) in an n-ary tree.

## Definitions

- **LCA (Lowest Common Ancestor):** The single, deepest shared parent for any set of nodes in a tree.
- **LDCA (Lowest Dominating Common Ancestors):** Multiple nodes forming the deepest set that dominates the paths to the nodes in a given descendant set, ensuring all routes to these descendants pass through this node set.

## Usage

- **LCA:** Use `NaryTreeLCAFinder.findLCA(TreeNode root, Set<TreeNode> nodes)` to find the lowest common ancestor of the given nodes.
- **LDCAs:** Use `NaryTreeLCAFinder.findLDCAs(TreeNode root, Set<TreeNode> nodes)` to find the lowest dominating common ancestors of the given nodes.
